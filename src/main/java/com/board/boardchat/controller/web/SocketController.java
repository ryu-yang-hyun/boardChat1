package com.board.boardchat.controller.web;

import com.board.boardchat.dto.SocketDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {
    // /receive를 메시지를 받을 endpoint로 설정합니다.
//    @MessageMapping("/receive")
//
//    // /send로 메시지를 반환합니다.
//    @SendTo("/send")
//
//    // SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
//    // 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
//    public SocketDto SocketHandler(SocketDto socketDto) {
//        String nick = socketDto.getNick();
//        String msg = socketDto.getMsg();
//
//        SocketDto result = new SocketDto(nick, msg);
//        // 반환
//        return result;
//    }
}
