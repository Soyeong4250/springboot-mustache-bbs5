package com.springboot.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitCreateRes {

    private String hospitalName;
    private String userName;
    private String disease;
    private float amount;

}
