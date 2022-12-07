package com.springboot.board.controller;

import com.springboot.board.domain.dto.ArticleRequestDto;
import com.springboot.board.domain.entity.Article;
import com.springboot.board.domain.entity.User;
import com.springboot.board.exception.ErrorCode;
import com.springboot.board.exception.SpringBootAppException;
import com.springboot.board.repository.ArticleRepository;
import com.springboot.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @GetMapping()
    public String articlesIndex() {
        return "redirect:/articles/list";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "articles/register";
    }

    @PostMapping()
    public String registArticles(ArticleRequestDto articleDto) {
        log.info(articleDto.toString());
        User user = userRepository.findByUserName(articleDto.getWriter())
                .orElseThrow(() -> new SpringBootAppException(ErrorCode.NOT_FOUND, String.format("%s와 일치하는 회원을 찾을 수 없습니다.", articleDto.getWriter())));
        Article savedArticle = articleRepository.save(Article.builder()
                                                    .title(articleDto.getTitle())
                                                    .content(articleDto.getContent())
                                                    .user(user)
                                                    .build());
        log.info("generatedId: {}", savedArticle.getId());
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }

    @GetMapping("/{id}")
    public String selectArticle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if(!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "articles/show";
        } else {
            model.addAttribute("message", String.format("%d번 게시글이 존재하지 않습니다.", id));
            return "error";
        }
    }

    @GetMapping("/list")
    public String articleList(Model model) {
        log.debug("articleList 호출");
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "articles/list";
    }

    @GetMapping("/{id}/edit")
    public String modifyArticlePage(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if(!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "articles/modify";
        } else {
            model.addAttribute("message", String.format("%d번 게시글이 존재하지 않습니다.", id));
            return "error";
        }
    }

    @PostMapping("/{id}/update")
    public String updateArticle(@PathVariable Long id, ArticleRequestDto articleDto, Model model) {
        log.debug("updateArticle 호출");
        log.info("title:{} content{}", articleDto.getTitle(), articleDto.getContent());
        User user = userRepository.findByUserName(articleDto.getWriter()).get();
        Article article = articleRepository.save(Article.builder()
                                                .title(articleDto.getTitle())
                                                .content(articleDto.getContent())
                                                .user(user)
                                                .build());
        model.addAttribute("article", article);
        return String.format("redirect:/articles/%d", article.getId());
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable Long id) {
        log.debug("deleteArticle 호출");
        articleRepository.deleteById(id);
        return "redirect:/articles";
    }
}
