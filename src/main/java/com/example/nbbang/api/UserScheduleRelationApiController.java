package com.example.nbbang.api;

import com.example.nbbang.dto.UserDto;
import com.example.nbbang.dto.UserScheduleRelationDto;
import com.example.nbbang.service.UserScheduleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserScheduleRelationApiController {

    @Autowired
    private UserScheduleRelationService userScheduleRelationService;

    @GetMapping("/api/userschedule/{userId}/{scheduleId}")
    public ResponseEntity<UserScheduleRelationDto> showRelation(@PathVariable Long userId, @PathVariable Long scheduleId){
        UserScheduleRelationDto relation = userScheduleRelationService.showRelation(userId, scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(relation);
    }

    @PostMapping("/api/userschedule/{userId}/{scheduleId}")
    public ResponseEntity<UserScheduleRelationDto> create(@PathVariable Long userId, @PathVariable Long scheduleId, @RequestBody UserScheduleRelationDto dto){
        UserScheduleRelationDto created = userScheduleRelationService.create(dto, userId, scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @DeleteMapping("/api/userschedule/{userId}/{scheduleId}")
    public ResponseEntity<UserScheduleRelationDto> delete(@PathVariable Long userId, @PathVariable Long scheduleId){
        UserScheduleRelationDto deleted = userScheduleRelationService.delete(userId, scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    @DeleteMapping("/api/userschedule/all/{scheduleId}")
    public ResponseEntity<String> deleteAll(@PathVariable Long scheduleId){
        userScheduleRelationService.deleteAllByScheduleId(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @GetMapping("/api/userschedule/{scheduleId}")
    public ResponseEntity<List<UserDto>> showRelationBySchedule(@PathVariable Long scheduleId){
        List<UserDto> dtos = userScheduleRelationService.showRelationBySchedule(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
}
