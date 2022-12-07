package com.springboot.board.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ArticleRequestDto {
    private String title;
    private String content;

    public ArticleRequestDto (String title, String content) {
        this.title = title;
        this.content = content;
    }

}
