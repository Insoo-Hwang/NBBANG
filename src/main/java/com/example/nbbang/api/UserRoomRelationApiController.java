package com.example.nbbang.api;

import com.example.nbbang.dto.UserRoomRelationDto;
import com.example.nbbang.service.UserRoomRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRoomRelationApiController {

    @Autowired
    private UserRoomRelationService userRoomRelationService;

    @PostMapping("/api/userroom/{userId}/{roomId}")
    public ResponseEntity<UserRoomRelationDto> create(@PathVariable Long userId, @PathVariable Long roomId, @RequestBody UserRoomRelationDto dto){
        UserRoomRelationDto createdDto = userRoomRelationService.create(dto, userId, roomId);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @GetMapping("/api/userroom/{userId}/{roomId}")
    public ResponseEntity<UserRoomRelationDto> showRelation(@PathVariable Long userId, @PathVariable Long roomId){
        UserRoomRelationDto dto = userRoomRelationService.showRelation(userId, roomId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/api/userroom/{userId}/{roomId}")
    public ResponseEntity<UserRoomRelationDto> deleteRelation(@PathVariable Long userId, @PathVariable Long roomId){
        UserRoomRelationDto dto = userRoomRelationService.deleteRelation(userId, roomId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
