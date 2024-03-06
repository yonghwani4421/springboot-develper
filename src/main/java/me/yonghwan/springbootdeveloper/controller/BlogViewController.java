package me.yonghwan.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.yonghwan.springbootdeveloper.domain.Article;
import me.yonghwan.springbootdeveloper.dto.ArticleListViewResponse;
import me.yonghwan.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream().map(ArticleListViewResponse::new).toList();

        model.addAttribute("articles",articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article",new ArticleListViewResponse(article));
        return "article";
    }
    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){
        if(id == null){
            model.addAttribute("article", new ArticleListViewResponse());
        } else{
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleListViewResponse(article));
        }

        return "newArticle";
    }

}
