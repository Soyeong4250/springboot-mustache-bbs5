package com.springboot.board.service;

import com.springboot.board.domain.dto.HospitalResponseDto;
import com.springboot.board.domain.entity.Hospital;
import com.springboot.board.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HospitalServiceTest {


    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);
    private HospitalService hospitalService;

    @BeforeEach
    public void setUp() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("영업 상태명이 잘 나오는지 테스트")
    public void getBusinessStatusNameTest() {
        Hospital openHospital = Hospital.builder()
                                .id(1)
                                .hospitalName("효치과의원")
                                .businessStatusCode(13)
                                .build();
        Mockito.when(hospitalRepository.findById(1)).thenReturn(Optional.of(openHospital));
        HospitalResponseDto openHospitalResponseDto = hospitalService.getHospital(1);
        assertEquals("영업중", openHospitalResponseDto.getBusinessStatusName());
        assertEquals("효치과의원", openHospitalResponseDto.getHospitalName());


        Hospital closeHospital = Hospital.builder()
                                .id(71857)
                                .hospitalName("최종범내과의원")
                                .businessStatusCode(3)
                                .build();
        Mockito.when(hospitalRepository.findById(71857)).thenReturn(Optional.of(closeHospital));
        HospitalResponseDto closeHospitalResponseDto = hospitalService.getHospital(71857);
        assertEquals("폐업", closeHospitalResponseDto.getBusinessStatusName());
        assertEquals("최종범내과의원", closeHospitalResponseDto.getHospitalName());
    }
}