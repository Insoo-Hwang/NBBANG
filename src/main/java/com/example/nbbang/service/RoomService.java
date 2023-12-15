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

    public List<RoomDto> getRooms(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        List<UserRoomRelation> userRoomRelations = userRoomRelationRepository.findByUser(user);
        List<Room> found = userRoomRelations.stream()
                .map(UserRoomRelation::getRoom)
                .collect(Collectors.toList());
        return found.stream()
                .map(room -> RoomDto.createRoomDto(room))
                .collect(Collectors.toList());
    }

    public List<UserDto> getUsers(Long id){
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        List<UserRoomRelation> userRoomRelations = userRoomRelationRepository.findByRoom(room);
        List<User> found = userRoomRelations.stream()
                .map(UserRoomRelation::getUser)
                .collect(Collectors.toList());
        return found.stream()
                .map(user -> UserDto.createUserDto(user))
                .collect(Collectors.toList());
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
}
