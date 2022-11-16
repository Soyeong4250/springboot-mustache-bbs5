package com.springboot.board.controller;

import com.springboot.board.domain.dto.HospitalResponseDto;
import com.springboot.board.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponseDto> get(@PathVariable Integer id) {
        HospitalResponseDto hospitalResponseDto = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponseDto);
    }
}
