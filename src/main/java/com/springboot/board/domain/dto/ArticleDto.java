package com.springboot.board.domain.dto;

import com.springboot.board.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ArticleDto {

    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
