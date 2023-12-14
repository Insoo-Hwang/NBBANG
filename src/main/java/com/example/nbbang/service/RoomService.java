package com.example.nbbang.service;

import com.example.nbbang.dto.RoomDto;
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
}
