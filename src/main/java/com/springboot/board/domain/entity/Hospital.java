package com.springboot.board.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

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


    public Hospital(Integer id, String roadNameAddress, String fullAddress, String hospitalName) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.fullAddress = fullAddress;
        this.hospitalName = hospitalName;
    }
}
