package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserJoinRes {

    private String userName;
    private String email;
    private UserRole role;

    @Builder
    public UserJoinRes(String userName, String email, UserRole role) {
        this.userName = userName;
        this.email = email;
        this.role = role;
    }
}
