package com.example.nbbang.entity;

import com.example.nbbang.dto.ArticleDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String content;

    public static Article createArticle(ArticleDto dto, Room room, User user) {
        return new Article(dto.getId(), room, user, dto.getContent());
    }


}
