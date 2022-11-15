package com.springboot.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class HospitalResponseDto {
    private Integer id;
    private String roadNameAddress;
    private String fullAddress;
    private String hospitalName;
    private String businessTypeName;
    private Integer totalNumberOfBeds;
}
