package com.springboot.board.controller;

import com.springboot.board.domain.dto.HospitalResponseDto;
import com.springboot.board.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalController.class)
class HospitalControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HospitalService hospitalService;

    @Test
    @DisplayName("1개의 JSON 형태로 Response가 잘 오는지")  // 비즈니스 로직(Service를 검증하지 않음) Controller만 검증
    void jsonResponse() throws Exception {
        HospitalResponseDto hospitalResponseDto = HospitalResponseDto.builder()
                .id(2321)
                .roadNameAddress("서울특별시 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)")
                .fullAddress("서울특별시 서초구 반포동 455번지 4호 동화프라자빌딩 202호")
                .hospitalName("노소아청소년과의원")
                .businessTypeName("의원")
                .totalNumberOfBeds(0)
                .businessStatusName("영업중")
                .build();
        given(hospitalService.getHospital(2321)).willReturn(hospitalResponseDto);

        int hospitalId = 2321;

        // 앞에서 Autowired한 mockMvc
        String url = String.format("/api/v1/hospitals/%d", hospitalId);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hospitalName").exists())  // $는 루트 $ 아래에 hospitalName이 있어야 함
                .andExpect(jsonPath("$.hospitalName").value("노소아청소년과의원"))
                .andDo(print());  // http request, response 내역 출력

        verify(hospitalService).getHospital(hospitalId);  // getHospital() 메소드의 호출이 있었는지 확인
    }
}