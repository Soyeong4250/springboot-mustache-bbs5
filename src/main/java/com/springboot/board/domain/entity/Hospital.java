package com.springboot.board.domain.entity;

import com.springboot.board.domain.dto.HospitalResponseDto;
import com.springboot.board.repository.HospitalRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals")
@NoArgsConstructor
@Getter
public class Hospital {
    @Id
    private Integer id;  // Long --> BigInt
    @Column(name = "road_name_address")
    private String roadNameAddress;
    @Column(name = "full_address")
    private String fullAddress;
    @Column(name = "hospital_name")
    private String hospitalName;
    @Column(name = "business_type_name")
    private String businessTypeName;
    @Column(name = "total_number_of_beds")
    private Integer totalNumberOfBeds;

    private Integer businessStatusCode;


    public Hospital(Integer id, String roadNameAddress, String fullAddress, String hospitalName, String businessTypeName, Integer totalNumberOfBeds) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.fullAddress = fullAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public static HospitalResponseDto of(Hospital hospital) {
        return new HospitalResponseDto(hospital.getId(), hospital.getRoadNameAddress(), hospital.getFullAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(), hospital.getTotalNumberOfBeds());
    }
}
