package com.springboot.board.service;

import com.springboot.board.domain.dto.VisitCreateReq;
import com.springboot.board.domain.dto.VisitViewRes;
import com.springboot.board.domain.entity.Hospital;
import com.springboot.board.domain.entity.User;
import com.springboot.board.domain.entity.Visit;
import com.springboot.board.exception.ErrorCode;
import com.springboot.board.exception.SpringBootAppException;
import com.springboot.board.repository.HospitalRepository;
import com.springboot.board.repository.UserRepository;
import com.springboot.board.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;

    public void createVisit(VisitCreateReq request, String userName) {
        Hospital hospital = hospitalRepository.findById(request.getHospitalId())
                .orElseThrow(() -> new SpringBootAppException(ErrorCode.NOT_FOUND, String.format("%d는(은) 존재하지 않는 병원입니다.", request.getHospitalId())));
        User user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new SpringBootAppException(ErrorCode.NOT_FOUND, String.format("%d는(은) 존재하지 않는 회원입니다.", request.getUserName())));

        Visit visit = Visit.builder()
                .hospital(hospital)
                .user(user)
                .disease(request.getDisease())
                .amount(request.getAmount())
                .build();
        Visit savedVisit = visitRepository.save(visit);
    }

    public List<VisitViewRes> getVisits(Pageable pageable) {
        Page<Visit> visitList = visitRepository.findAll(pageable);
        List<VisitViewRes> visitViewResList = visitList.stream().map(VisitViewRes::of).collect(Collectors.toList());
        return visitViewResList;
    }

    public List<VisitViewRes> getVisitsByUserId(Long id) {
        List<Visit> visitList = visitRepository.findByUserId(id);
        return visitList.stream().map(VisitViewRes::of).collect(Collectors.toList());
    }

    public List<VisitViewRes> getVisitsByHospitalId(Integer id) {
        List<Visit> visitList = visitRepository.findByHospitalId(id);
        return visitList.stream().map(VisitViewRes::of).collect(Collectors.toList());
    }
}
