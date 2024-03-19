package me.yonghwan.springbootdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.yonghwan.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ArticleListViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    private String author;


    public ArticleListViewResponse( Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreateAt();
        this.author = article.getAuthor();
    }
}
