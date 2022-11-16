package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.Article;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
public class ArticleRequestDto {
    private String title;
    private String content;

    public ArticleRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(this.title, this.content);
    }
}
