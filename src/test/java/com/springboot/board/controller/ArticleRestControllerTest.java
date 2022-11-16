package com.springboot.board.controller;

import com.springboot.board.domain.dto.ArticleResponseDto;
import com.springboot.board.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
public class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("1개의 게시글이 JSON 형태로 데이터가 잘 전달되는지 테스트")
    void jsonResponse() throws Exception {
        ArticleResponseDto articleResponseDto = ArticleResponseDto.builder()
                .id(8L)
                .title("likelionboard")
                .content("lieklion")
                .build();
        given(articleService.getArticle(8L)).willReturn((articleResponseDto));

        Long articleId = 8L;

        mockMvc.perform(get(String.format("/api/v1/articles/%d", articleId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("likelionboard"))
                .andDo(print());
        verify(articleService).getArticle(articleId);
    }
}
