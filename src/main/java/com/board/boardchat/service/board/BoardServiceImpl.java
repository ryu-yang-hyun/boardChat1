package com.board.boardchat.service.board;

import com.board.boardchat.common.GetSort;
import com.board.boardchat.common.StatusEnum;
import com.board.boardchat.dto.BoardDto;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.entity.AccountEntity;
import com.board.boardchat.model.Board;
import com.board.boardchat.model.Role;
import com.board.boardchat.model.User;
import com.board.boardchat.repository.board.BoardRepository;
import com.board.boardchat.service.account.AccountService;
import com.google.gson.Gson;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Inject
    private BoardRepository boardRepository;

    @Inject
    private AccountService accountService;

    public BoardServiceImpl(BoardRepository boardRepository, AccountService accountService) {
        this.boardRepository = boardRepository;
        this.accountService = accountService;
    }

    /**
     * 조회
     */
    @Override
    public ResponseEntity boardList (String keyword, Integer offset, Integer limit, HttpServletRequest request) {

        ResponseEntity responseEntity = sessionUserCheck(request);
        if(!"OK".equals(responseEntity.getCode())) {
            return responseEntity;
        }

        Pageable pageable = PageRequest.of(offset,limit, GetSort.getSort("createAt", "desc"));
        Page<Board> list  = boardRepository.findAll(pageable);
        responseEntity.setData(list.getContent().stream().map( x -> convertDto(x)));
        responseEntity.setTotalCount(list.getTotalElements());
        return responseEntity;
    }

    private BoardDto convertDto(Board source) {
        BoardDto target = new BoardDto();
        target.setId(source.getId());
        target.setContent(source.getContent());
        target.setTitle(source.getTitle());
        return target;
    }

    /**
     * 등록
     */
    @Override
    public ResponseEntity insertBoard(BoardDto boardDto, HttpServletRequest request) {

        ResponseEntity responseEntity = sessionUserCheck(request);
        if(!"OK".equals(responseEntity.getCode())) {
            return responseEntity;
        }

        Gson gson = new Gson();
        String checkData = gson.toJson(responseEntity.getData());
        Board board = gson.fromJson(checkData,Board.class);

        board.setCreateBy(board.getUser().getName());
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        responseEntity.setData(boardRepository.save(board));
        if(responseEntity == null) {
            responseEntity.setCode(StatusEnum.INTERNAL_SERER_ERROR.toString());
        }

        return responseEntity;
    }


    /**
     * 상세
     */
    @Override
    public ResponseEntity details(BoardDto boardDto, HttpServletRequest request) throws ServiceException {

        //user, session Check
        ResponseEntity responseEntity = sessionUserCheck(request);

        if(!"OK".equals(responseEntity.getCode())) {
            return responseEntity;
        }

        Optional<Board> optionalBoardDto = boardRepository.findBoardId(boardDto.getId());
        if(!optionalBoardDto.isPresent()) {
            responseEntity.setMessage("Board 정보가 없습니다.");
            return responseEntity;
        }

        responseEntity.setData(optionalBoardDto.get());

        return responseEntity;
    }

    /**
     * 수정
     */
    @Override
    public ResponseEntity updateModify(BoardDto boardDto, HttpServletRequest request) throws ServiceException {

        //user, session Check
        ResponseEntity responseEntity = sessionUserCheck(request);

        if(!"OK".equals(responseEntity.getCode())) {
            return responseEntity;
        }
        Gson gson = new Gson();
        String checkData = gson.toJson(responseEntity.getData());
        Board board = gson.fromJson(checkData,Board.class);

        Optional<Board> checkBoard = boardRepository.findBoardId(boardDto.getId());

        if(board.getUser().getId() != checkBoard.get().getUser().getId()) {
            responseEntity.setMessage("수정 할 수 없습니다.");
            return responseEntity;
        }

        board.setId(boardDto.getId());

        Optional<Board> optionalBoard = boardRepository.findById(board.getId());
        if(!optionalBoard.isPresent()) {
            responseEntity.setMessage("Board 정보가 없습니다.");
            return responseEntity;
        }

        board = optionalBoard.get();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setModifiedAt(LocalDateTime.now());
        board.setModifiedBy(board.getUser().getName());
        responseEntity.setData(boardRepository.save(board));

        return responseEntity;
    }

    /**
     * 권한 add
     */
    public List<Role> customRole(List<Role> role) {
        List<Role> roles = new ArrayList<>();
        Role cuRoles = new Role();
        for(Role list : role) {
            cuRoles.setId(list.getId());
            cuRoles.setName(list.getName());
            roles.add(cuRoles);
        }
        return roles;
    }

    public ResponseEntity sessionUserCheck(HttpServletRequest request){

        ResponseEntity responseEntity = new ResponseEntity();
        HttpSession session = request.getSession();
        if (session.getAttribute("USER") == null) {
            responseEntity.setMessage("로그인 정보가 없습니다. 관리자에게 문의해 주세요.");
            return responseEntity;
        }

        AccountEntity accountEntity = (AccountEntity) session.getAttribute("USER");

        Board board = new Board();
        Optional<User> userCheck = accountService.userCheck(accountEntity.getId());
        if(!userCheck.isPresent()) {
            responseEntity.setMessage("회원 정보가 없습니다. 관리자에게 문의해 주세요.");
            return responseEntity;
        }
        responseEntity.setCode(StatusEnum.OK.toString());

        userCheck.get().setRoles(customRole(userCheck.get().getRoles()));
        board.setUser(userCheck.get());
        responseEntity.setData(board);

        return responseEntity;
    }
}
