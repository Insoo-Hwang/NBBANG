package com.example.nbbang.service;

import com.example.nbbang.dto.ScheduleDto;
import com.example.nbbang.entity.Room;
import com.example.nbbang.entity.Schedule;
import com.example.nbbang.repository.RoomRepository;
import com.example.nbbang.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<ScheduleDto> schedules(Long roodId){
        return  scheduleRepository.findByRoomId(roodId)
                .stream()
                .map(schedule -> ScheduleDto.createScheduleDto(schedule))
                .collect(Collectors.toList());
    }

    public ScheduleDto schedule(Long id){
        return ScheduleDto.createScheduleDto(scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException()));
    }

    @Transactional
    public ScheduleDto create(Long roomId, ScheduleDto dto){
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException());
        Schedule schedule = Schedule.createSchedule(dto, room);
        Schedule created = scheduleRepository.save(schedule);
        return ScheduleDto.createScheduleDto(created);
    }

    @Transactional
    public ScheduleDto delete(Long id){
        Schedule target = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        scheduleRepository.delete(target);
        return ScheduleDto.createScheduleDto(target);
    }

    @Transactional
    public ScheduleDto update(Long id, ScheduleDto dto){
        Schedule target = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        target.patch(dto);
        Schedule updated = scheduleRepository.save(target);
        return ScheduleDto.createScheduleDto(updated);
    }
}
