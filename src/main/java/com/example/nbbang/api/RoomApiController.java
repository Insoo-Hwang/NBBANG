package com.example.nbbang.api;

import com.example.nbbang.dto.RoomDto;
import com.example.nbbang.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRange;
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

    @GetMapping("/api/room/{code}")
    public ResponseEntity<RoomDto> findByCode(@PathVariable String code){
        RoomDto dto = roomService.findByCode(code);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/api/room/{id}")
    public ResponseEntity<RoomDto> delete(@PathVariable Long id){
        RoomDto dto = roomService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/api/room/public")
    private ResponseEntity<List<RoomDto>> findPublic(){
        List<RoomDto> dtos = roomService.findByShow();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
