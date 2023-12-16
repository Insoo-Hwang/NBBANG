package com.example.nbbang.repository;

import com.example.nbbang.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * FROM article WHERE room_id = :roomId", nativeQuery = true)
    List<Article> findByRoomId(Long roomId);
}
