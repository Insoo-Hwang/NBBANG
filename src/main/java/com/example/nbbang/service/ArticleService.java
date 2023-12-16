package com.example.nbbang.service;

import com.example.nbbang.dto.ArticleDto;
import com.example.nbbang.entity.Article;
import com.example.nbbang.entity.Room;
import com.example.nbbang.entity.User;
import com.example.nbbang.repository.ArticleRepository;
import com.example.nbbang.repository.RoomRepository;
import com.example.nbbang.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ArticleDto> articles(Long roodId){
        List<ArticleDto> list = articleRepository.findByRoomId(roodId)
                .stream()
                .map(article -> ArticleDto.createArticleDto(article))
                .collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }

    @Transactional
    public ArticleDto create(Long roomId, Long userId, ArticleDto dto){
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException());
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        Article article = Article.createArticle(dto, room, user);
        Article created = articleRepository.save(article);
        return ArticleDto.createArticleDto(created);
    }

    @Transactional
    public ArticleDto delete(Long id){
        Article target = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        articleRepository.delete(target);
        return ArticleDto.createArticleDto(target);
    }
}
