package com.example.nbbang.dto;

import com.example.nbbang.entity.Article;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ArticleDto {

    private Long id;

    @JsonProperty("room_id")
    private Long roomId;

    @JsonProperty("user_id")
    private Long userId;

    private String content;

    private String nickname;

    public static ArticleDto createArticleDto(Article article) {
        return new ArticleDto(article.getId(), article.getRoom().getId(), article.getUser().getId(), article.getContent(), article.getUser().getNickname());
    }
}
