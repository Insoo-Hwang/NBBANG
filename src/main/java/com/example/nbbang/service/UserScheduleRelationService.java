package com.example.nbbang.service;

import com.example.nbbang.dto.UserDto;
import com.example.nbbang.dto.UserScheduleRelationDto;
import com.example.nbbang.entity.Schedule;
import com.example.nbbang.entity.User;
import com.example.nbbang.entity.UserScheduleRelation;
import com.example.nbbang.repository.ScheduleRepository;
import com.example.nbbang.repository.UserRepository;
import com.example.nbbang.repository.UserScheduleRelationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserScheduleRelationService {

    @Autowired
    private UserScheduleRelationRepository userScheduleRelationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public UserScheduleRelationDto showRelation(Long userId, Long scheduleId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException());
        UserScheduleRelation relation = userScheduleRelationRepository.findByUserAndSchedule(user, schedule);
        if(relation != null) {
            return UserScheduleRelationDto.createUserScheduleDto(relation);
        }
        else
            return null;
    }

    public List<UserDto> showRelationBySchedule(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException());
        List<UserScheduleRelation> relations = userScheduleRelationRepository.findBySchedule(schedule);
        List<User> found = relations.stream()
                .map(UserScheduleRelation::getUser)
                .collect(Collectors.toList());
        return found.stream()
                .map(user -> UserDto.createUserDto(user))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserScheduleRelationDto create(UserScheduleRelationDto dto, Long userId, Long scheduleId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException());
        UserScheduleRelation relation = UserScheduleRelation.createUserScheduleRelation(dto, user, schedule);
        UserScheduleRelation created = userScheduleRelationRepository.save(relation);
        return UserScheduleRelationDto.createUserScheduleDto(created);
    }

    @Transactional
    public UserScheduleRelationDto delete(Long userId, Long scheduleId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException());
        UserScheduleRelation target = userScheduleRelationRepository.findByUserAndSchedule(user, schedule);
        userScheduleRelationRepository.delete(target);
        return UserScheduleRelationDto.createUserScheduleDto(target);
    }

    @Transactional
    public void deleteAllByScheduleId(Long scheduleId){
        userScheduleRelationRepository.deleteByScheduleId(scheduleId);
    }
}
