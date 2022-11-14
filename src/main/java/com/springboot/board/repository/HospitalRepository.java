package com.springboot.board.repository;

import com.springboot.board.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    Page<Hospital> findAll(Pageable pageable);
}
