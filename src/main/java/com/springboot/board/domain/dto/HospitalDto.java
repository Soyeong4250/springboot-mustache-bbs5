package com.springboot.board.domain.dto;

import com.springboot.board.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class HospitalDto {
    private int id;
    private String roadNameAddress;
    private String hospitalName;

    public Hospital toEntity() {
        return new Hospital(this.id, this.roadNameAddress, this.hospitalName);
    }
}
