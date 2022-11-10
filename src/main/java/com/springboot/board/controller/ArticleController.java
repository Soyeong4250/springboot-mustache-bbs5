package com.springboot.board.controller;

import com.springboot.board.domain.Article;
import com.springboot.board.domain.dto.ArticleDto;
import com.springboot.board.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "article/register";
    }

    @PostMapping("")
    public String registArticles(ArticleDto articleDto) {
        log.info(articleDto.toString());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generatedId: {}", savedArticle.getId());
        return "";
    }
}
