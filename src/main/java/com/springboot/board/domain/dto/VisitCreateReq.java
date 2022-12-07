package com.springboot.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VisitCreateReq {

    private Integer hospitalId;
    private String userName;
    private String disease;
    private Integer amount;

}
