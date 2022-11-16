package com.springboot.board.domain.entity;

import com.springboot.board.domain.dto.ArticleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "article")
@NoArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static ArticleResponseDto of(Article article) {
        return new ArticleResponseDto(article.getId(), article.getTitle(), article.getContent());
    }
}
