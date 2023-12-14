package com.example.nbbang.api;

import com.example.nbbang.dto.RoomDto;
import com.example.nbbang.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomApiController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/api/room")
    public ResponseEntity<RoomDto> create(@RequestBody RoomDto dto){
        RoomDto created = roomService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

}
