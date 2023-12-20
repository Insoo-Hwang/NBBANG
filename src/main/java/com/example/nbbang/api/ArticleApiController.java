package com.example.nbbang.api;

import com.example.nbbang.dto.ArticleDto;
import com.example.nbbang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/articles/{roomId}/{userId}")
    public ResponseEntity<ArticleDto> create(@PathVariable Long roomId, @PathVariable Long userId, @RequestBody ArticleDto dto){
        ArticleDto createdDto = articleService.create(roomId, userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<ArticleDto> delete(@PathVariable Long id){
        ArticleDto deletedDto = articleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }

    @GetMapping("/api/articles/{roomId}")
    public ResponseEntity<List<ArticleDto>> articles(@PathVariable Long roomId){
        List<ArticleDto> articleDtos = articleService.articles(roomId);
        return ResponseEntity.status(HttpStatus.OK).body(articleDtos);
    }
}
