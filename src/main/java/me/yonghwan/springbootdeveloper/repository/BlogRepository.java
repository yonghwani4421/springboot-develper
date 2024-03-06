package me.yonghwan.springbootdeveloper.repository;

import me.yonghwan.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
