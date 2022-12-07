package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.User;
import com.springboot.board.domain.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinReq {

    private String userName;
    private String password;
    private String email;

    public User toEntity(String password) {
        return User.builder()
                .userName(this.userName)
                .password(password)
                .email(this.email)
                .role(UserRole.USER)
                .build();
    }
}
