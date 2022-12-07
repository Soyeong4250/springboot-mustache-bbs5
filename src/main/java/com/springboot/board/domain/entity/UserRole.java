package com.springboot.board.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER")
    ;

    private String name;
}
