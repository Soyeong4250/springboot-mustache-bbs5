package com.springboot.board.domain.entity;

import com.springboot.board.exception.ErrorCode;
import com.springboot.board.exception.SpringBootAppException;
import com.springboot.board.repository.ArticleRepository;
import com.springboot.board.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaseEntityTest {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Article AuditingTest 실행")
    public void articleAuditingTest() {
        String userName = "likelion";
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new SpringBootAppException(ErrorCode.NOT_FOUND, String.format("%s는(은) 존재하지 않는 회원입니다.")));
        System.out.println(user.toString());
        Article article = Article.builder()
                                .title("Article Auditing Test 제목")
                                .content("Article Auditing Test 내용")
                                .user(user)
                                .build();
        Article savedArticle = articleRepository.save(article);
        System.out.println(savedArticle.toString());
    }

}