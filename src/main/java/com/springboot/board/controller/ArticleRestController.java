package com.springboot.board.controller;

import com.springboot.board.domain.dto.ArticleRequestDto;
import com.springboot.board.domain.dto.ArticleResponseDto;
import com.springboot.board.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> get(@PathVariable Long id) {
        ArticleResponseDto articleResponseDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ArticleResponseDto> register(@RequestBody ArticleRequestDto articleRequestDto, Authentication authentication) {
        String userName = authentication.getName();
        log.info("userName: {}", userName);
        ArticleResponseDto articleResponseDto = articleService.saveArticle(articleRequestDto, userName);
        return ResponseEntity.ok().body(articleResponseDto);
    }
}
