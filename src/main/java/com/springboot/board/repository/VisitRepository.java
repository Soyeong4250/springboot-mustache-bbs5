package com.springboot.board.repository;

import com.springboot.board.domain.entity.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    Page<Visit> findAll(Pageable pageable);

    List<Visit> findByUserId(Long userId);

    List<Visit> findByHospitalId(Integer hospitalId);
}
