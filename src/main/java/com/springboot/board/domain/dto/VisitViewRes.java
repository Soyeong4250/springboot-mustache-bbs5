package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitViewRes {

    private String hospitalName;
    private String userName;
    private String disease;
    private Integer amount;

    public static VisitViewRes of(Visit visit) {
        return VisitViewRes.builder()
                .hospitalName(visit.getHospital().getHospitalName())
                .userName(visit.getUser().getUserName())
                .disease(visit.getDisease())
                .amount(visit.getAmount())
                .build();
    }
}
