package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class HospitalRequestDto {
    private int id;
    private String roadNameAddress;
    private String fullAddress;
    private String hospitalName;
    private String businessTypeName;
    private int totalNumberOfBeds;
    private Integer businessStatusCode;

    public Hospital toEntity() {
        return Hospital.builder()
                .id(this.id)
                .roadNameAddress(this.roadNameAddress)
                .fullAddress(this.fullAddress)
                .hospitalName(this.hospitalName)
                .businessTypeName(this.businessTypeName)
                .totalNumberOfBeds(this.totalNumberOfBeds)
                .businessStatusCode(this.businessStatusCode)
                .build();
    }
}
