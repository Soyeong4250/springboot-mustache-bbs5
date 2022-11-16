package com.springboot.board.controller;

import com.springboot.board.domain.dto.ArticleResponseDto;
import com.springboot.board.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("{id}")
    public ResponseEntity<ArticleResponseDto> get(@PathVariable Long id) {
        ArticleResponseDto articleResponseDto = articleService.getArticle(id);
        return ResponseEntity.ok().body(articleResponseDto);
    }
}
