package me.yonghwan.springbootdeveloper.dto;

import lombok.Getter;
import me.yonghwan.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@Getter
public class ArticleResponse {
    private String title;
    private String content;


    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();

    }
}
