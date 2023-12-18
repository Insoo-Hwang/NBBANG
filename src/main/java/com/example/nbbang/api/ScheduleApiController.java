package com.example.nbbang.api;

import com.example.nbbang.dto.ScheduleDto;
import com.example.nbbang.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleApiController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/api/schedule/{roomId}")
    public ResponseEntity<ScheduleDto> create(@PathVariable Long roomId, @RequestBody ScheduleDto dto){
        ScheduleDto created = scheduleService.create(roomId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @DeleteMapping("/api/schedule/{id}")
    public ResponseEntity<ScheduleDto> delete(@PathVariable Long id){
        ScheduleDto deleted = scheduleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    @PatchMapping("/api/schedule/{id}")
    public ResponseEntity<ScheduleDto> update(@PathVariable Long id, @RequestBody ScheduleDto dto){
        ScheduleDto updated = scheduleService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}
