package com.springboot.board.controller;

import com.springboot.board.domain.Hospital;
import com.springboot.board.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/list")
    public String hospitalList(Model model) {
        log.debug("hospitalList 호출");
        List<Hospital> hospitalList = hospitalRepository.findAll();
        model.addAttribute("hospitals", hospitalList);
        return "hospitals/list";
    }
}
