package com.springboot.board.domain.entity;

import lombok.Builder;
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

}
