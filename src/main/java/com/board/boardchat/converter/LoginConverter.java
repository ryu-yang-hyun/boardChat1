package com.board.boardchat.converter;

import com.board.boardchat.common.AbstractDataConverter;
import com.board.boardchat.entity.AccountEntity;
import com.board.boardchat.model.Role;
import com.board.boardchat.model.User;
import org.springframework.core.convert.ConversionException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class LoginConverter extends AbstractDataConverter<User, AccountEntity> {

    @Override
    protected AccountEntity createTarget() {
        return new AccountEntity();
    }

    @Override
    public AccountEntity convert(User user, AccountEntity accountEntity) throws ConversionException {

        accountEntity.setId(user.getId());
        accountEntity.setUserId(user.getUserId());
        accountEntity.setEmail(user.getEmail());
        accountEntity.setGender(user.getGender());
        accountEntity.setName(user.getName());
        accountEntity.setCreateAt(user.getCreateAt());

        if (!CollectionUtils.isEmpty(user.getRoles())) {
           accountEntity.setRole(customRole(user.getRoles()));
        }

        return accountEntity;
    }

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
}
