package com.springboot.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.board.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArticleRestController.class)
public class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ArticleService articleService;

    /*@Test
    @DisplayName("1개의 게시글이 JSON 형태로 데이터가 잘 전달되는지 테스트")
    void jsonResponse() throws Exception {
        ArticleResponseDto articleResponseDto = ArticleResponseDto.builder()
                .id(8L)
                .title("likelionboard")
                .content("likelion")
                .build();
        // given() : 메서드 호출과 주입받는 파라미터 가정 & willReturn() : 비교할 객체 Dto
        given(articleService.getArticle(8L)).willReturn((articleResponseDto));

        Long articleId = 8L;

        mockMvc.perform(get(String.format("/api/v1/articles/%d", articleId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpectAll(jsonPath("$.title").value("likelionboard"), jsonPath("$.content").value("likelion"))
                .andDo(print());
        verify(articleService).getArticle(articleId);
    }

    @Test
    @DisplayName("게시글이 잘 저장되는지 테스트")
    void registerArticle() throws Exception {
        ArticleRequestDto articleRequestDto = new ArticleRequestDto("Controller Test", "registerArticle Test");
        given(articleService.saveArticle(any(ArticleRequestDto.class), any()))
                .willReturn(new ArticleResponseDto(15L, articleRequestDto.getTitle(), articleRequestDto.getContent(), any()));

        mockMvc.perform(post("/api/v1/articles")
                    .content(objectMapper.writeValueAsBytes(articleRequestDto))
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).saveArticle(ArgumentMatchers.refEq(articleRequestDto), "test");
    }*/
}
