package com.example.nbbang.service;

import com.example.nbbang.dto.RoomDto;
import com.example.nbbang.dto.UserDto;
import com.example.nbbang.entity.Room;
import com.example.nbbang.entity.User;
import com.example.nbbang.entity.UserRoomRelation;
import com.example.nbbang.repository.RoomRepository;
import com.example.nbbang.repository.UserRepository;
import com.example.nbbang.repository.UserRoomRelationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoomRelationRepository userRoomRelationRepository;

    @Transactional
    public RoomDto create(RoomDto dto){
        Room room = Room.createRoom(dto);
        Room created = roomRepository.save(room);
        return RoomDto.createRoomDto(created);
    }



    public RoomDto show(Long id){
        return RoomDto.createRoomDto(roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException()));
    }

    public RoomDto findByCode(String code){
        return RoomDto.createRoomDto(roomRepository.findByCode(code).orElseThrow(() -> new IllegalArgumentException()));
    }

    @Transactional
    public RoomDto delete(Long id){
        Room target = roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        roomRepository.delete(target);
        return RoomDto.createRoomDto(target);
    }

    public List<RoomDto> findByShow(){
        return roomRepository.findByShow()
                .stream()
                .map(room -> RoomDto.createRoomDto(room))
                .collect(Collectors.toList());
    }

    @Transactional
    public RoomDto update(Long id, RoomDto dto){
        Room target = roomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        target.patch(dto);
        Room updated = roomRepository.save(target);
        return RoomDto.createRoomDto(updated);
    }
}
