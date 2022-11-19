package com.springboot.board.controller;

import com.springboot.board.domain.entity.Hospital;
import com.springboot.board.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping()
    public String hospitalList(@RequestParam(required = false) String keyword, @PageableDefault(size = 10) Pageable pageable, Model model) {
        log.debug("hospitalList 호출");
        log.info("keyword : {}", keyword);
        Page<Hospital> hospitalList = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
        model.addAttribute("hospitals", hospitalList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasPrev", hospitalList.hasPrevious());
        model.addAttribute("hasNext", hospitalList.hasNext());
        return "hospitals/list";

    }
}