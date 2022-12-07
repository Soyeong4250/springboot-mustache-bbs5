package com.springboot.board.service;

import com.springboot.board.domain.dto.ArticleRequestDto;
import com.springboot.board.domain.dto.ArticleResponseDto;
import com.springboot.board.domain.entity.Article;
import com.springboot.board.domain.entity.User;
import com.springboot.board.exception.ErrorCode;
import com.springboot.board.exception.SpringBootAppException;
import com.springboot.board.repository.ArticleRepository;
import com.springboot.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;


    public ArticleResponseDto getArticle(Long id) {
        Optional<Article> optArticle = articleRepository.findById(id);
        return ArticleResponseDto.of(optArticle.get());
    }

    public ArticleResponseDto saveArticle(ArticleRequestDto request, String userName) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new SpringBootAppException(ErrorCode.NOT_FOUND, String.format("%d는(은) 존재하지 않는 회원입니다.", userName)));
        Article article = Article.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .user(user).build();
        Article savedArticle = articleRepository.save(article);

        return ArticleResponseDto.of(savedArticle);
    }
}
