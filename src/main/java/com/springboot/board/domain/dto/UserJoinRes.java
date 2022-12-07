package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserJoinRes {

    private String userName;
    private String email;
    private UserRole role;

}
