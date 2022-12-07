package com.springboot.board.controller;

import com.springboot.board.domain.dto.VisitCreateReq;
import com.springboot.board.domain.dto.VisitViewRes;
import com.springboot.board.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/visits")
public class VisitRestContorller {

    private final VisitService visitService;

    @PostMapping()
    public ResponseEntity<String> createVisitLog(@RequestBody VisitCreateReq request, Authentication authentication) {
        String userName = authentication.getName();
        log.info("userName: {}", userName);
        visitService.createVisit(request, userName);
        return ResponseEntity.ok().body("방문 기록 등록이 완료되었습니다.");
    }

    @GetMapping()
    public ResponseEntity<List<VisitViewRes>> getVisits(Pageable pageable) {
        return ResponseEntity.ok().body(visitService.getVisits(pageable));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<VisitViewRes>> getVisitsByUserId(@PathVariable Long id) {
        return ResponseEntity.ok().body(visitService.getVisitsByUserId(id));
    }

    @GetMapping("/hospitals/{id}")
    public ResponseEntity<List<VisitViewRes>> getVisitsByHospitalId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(visitService.getVisitsByHospitalId(id));
    }
}
