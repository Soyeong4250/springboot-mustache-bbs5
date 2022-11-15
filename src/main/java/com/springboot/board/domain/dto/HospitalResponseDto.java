package com.springboot.board.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HospitalResponseDto {
    private Integer id;
    private String roadNameAddress;
    private String fullAddress;
    private String hospitalName;
    private String businessTypeName;
    private Integer totalNumberOfBeds;
    private String businessStatusName;

    public HospitalResponseDto(Integer id, String roadNameAddress, String fullAddress, String hospitalName, String businessTypeName, Integer totalNumberOfBeds) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.fullAddress = fullAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }
}
