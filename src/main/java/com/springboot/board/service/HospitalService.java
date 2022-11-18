package com.springboot.board.service;

import com.springboot.board.domain.dto.HospitalResponseDto;
import com.springboot.board.domain.entity.Hospital;
import com.springboot.board.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponseDto getHospital(Integer id) {

        Optional<Hospital> optHospital = hospitalRepository.findById(id);  // Entity
        Hospital hospital =  optHospital.get();
        HospitalResponseDto hospitalResponseDto = Hospital.of(hospital);  // DTO

        switch (hospital.getBusinessStatusCode()) {
            case 13: hospitalResponseDto.setBusinessStatusName("영업중"); break;
            case 3: hospitalResponseDto.setBusinessStatusName("폐업"); break;
            default: hospitalResponseDto.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode())); break;
        }

        return hospitalResponseDto;
    }
}
