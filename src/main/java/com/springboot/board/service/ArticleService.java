package com.springboot.board.service;

import com.springboot.board.domain.dto.ArticleRequestDto;
import com.springboot.board.domain.dto.ArticleResponseDto;
import com.springboot.board.domain.entity.Article;
import com.springboot.board.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;


    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleResponseDto getArticle(Long id) {
        Optional<Article> optArticle = articleRepository.findById(id);
        Article article = optArticle.get();
        return Article.of(article);
    }

    public ArticleResponseDto saveArticle(ArticleRequestDto articleRequestDto) {
        Article article = articleRequestDto.toEntity();
        Article savedArticle = articleRepository.save(article);

        ArticleResponseDto articleResponseDto = new ArticleResponseDto(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());
        return articleResponseDto;
    }
}
