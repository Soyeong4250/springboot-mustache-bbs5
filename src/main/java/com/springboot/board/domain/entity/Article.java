package com.springboot.board.domain.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseEntity{

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
