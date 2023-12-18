package com.example.nbbang.repository;

import com.example.nbbang.entity.Room;
import com.example.nbbang.entity.User;
import com.example.nbbang.entity.UserRoomRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoomRelationRepository extends JpaRepository<UserRoomRelation, Long> {
    List<UserRoomRelation> findByUser(User user);

    List<UserRoomRelation> findByRoom(Room room);

    UserRoomRelation findByUserAndRoom(User user, Room room);
}
