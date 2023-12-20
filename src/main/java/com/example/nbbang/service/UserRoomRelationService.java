package com.example.nbbang.service;

import com.example.nbbang.dto.RoomDto;
import com.example.nbbang.dto.UserDto;
import com.example.nbbang.dto.UserRoomRelationDto;
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
public class UserRoomRelationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRoomRelationRepository userRoomRelationRepository;

    @Transactional
    public UserRoomRelationDto create(UserRoomRelationDto dto, Long userId, Long roomId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException());
        UserRoomRelation relation = UserRoomRelation.createUserRoomRelation(dto, user, room);
        UserRoomRelation created = userRoomRelationRepository.save(relation);
        return UserRoomRelationDto.createUserRoomRelationDto(created);
    }

    public UserRoomRelationDto showRelation(Long userId, Long roomId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException());
        UserRoomRelation relation = userRoomRelationRepository.findByUserAndRoom(user, room);
        if(relation != null) {
            return UserRoomRelationDto.createUserRoomRelationDto(relation);
        }
        else
            return null;
    }

    @Transactional
    public UserRoomRelationDto deleteRelation(Long userId, Long roomId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException());
        UserRoomRelation relation = userRoomRelationRepository.findByUserAndRoom(user, room);
        if(relation != null) {
            userRoomRelationRepository.delete(relation);
            return UserRoomRelationDto.createUserRoomRelationDto(relation);
        }
        else{
            return null;
        }
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

    @Transactional
    public void deleteAllByRoomId(Long roomId){
        userRoomRelationRepository.deleteByRoomId(roomId);
    }
}
