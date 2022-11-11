package com.springboot.board.controller;

import com.springboot.board.domain.Article;
import com.springboot.board.domain.dto.ArticleDto;
import com.springboot.board.repository.ArticleRepository;
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
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping()
    public String articlesIndex() {
        return "redirect:/articles/list";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "articles/register";
    }

    @PostMapping()
    public String registArticles(ArticleDto articleDto) {
        log.info(articleDto.toString());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
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
    public String updateArticle(@PathVariable Long id, ArticleDto articleDto, Model model) {
        log.debug("updateArticle 호출");
        log.info("title:{} content{}", articleDto.getTitle(), articleDto.getContent());
        Article article = articleRepository.save(articleDto.toEntity());
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
