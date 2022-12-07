package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponseDto {

    private Long id;
    private String title;
    private String content;
    private String writer;

    public static ArticleResponseDto of(Article article) {
        return ArticleResponseDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .writer(article.getUser().getUserName())
                .build();
    }
}
