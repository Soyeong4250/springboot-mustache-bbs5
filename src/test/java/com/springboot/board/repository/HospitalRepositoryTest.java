package com.springboot.board.repository;

import com.springboot.board.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("Hospital 정보를 잘 가져오는지 테스트")
    void getHospital() {
        hospitalRepository.findById(1);
        Optional<Hospital> hospital = hospitalRepository.findById(1);
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        assertEquals(1, hp.getId());
    }

    @Test
    @DisplayName("BusinessTypeName이 보건소 보건지소 보건진료소인 데이터가 잘 나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);

        printHospitalsInfo(hospitals);
    }

    @Test
    @DisplayName("Containing을 이용한 Like 검색")
    void containing() {
        List<Hospital> hospitals = hospitalRepository.findByFullAddressContaining("송파구");
        printHospitalsInfo(hospitals);
    }

    @Test
    @DisplayName("StartsWith를 이용한 Like 검색")
    void startsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartsWith("경희");
        printHospitalsInfo(hospitals);
    }

    @Test
    @DisplayName("EndsWith를 이용한 Like 검색")
    void endsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("병원");
        printHospitalsInfo(hospitals);
    }

    @Test
    @DisplayName("Between을 이용하여 조건에 맞는 병상 수를 가진 병원 리스트 조회")
    void between() {
        List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsBetween(10, 19);  // 20미만 이므로 19이하까지만 구하기
        printHospitalsInfo(hospitals);
    }

    void printHospitalsInfo(List<Hospital> hospitals) {
        for (var hospital : hospitals) {
            System.out.printf("%s | %s | %d\n", hospital.getHospitalName(), hospital.getFullAddress(), hospital.getTotalNumberOfBeds());
        }

        System.out.println(hospitals.size());
    }

}