package com.example.nbbang.repository;

import com.example.nbbang.entity.User;
import com.example.nbbang.entity.UserRoomRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoomRelationRepository extends JpaRepository<UserRoomRelation, Long> {
    List<UserRoomRelation> findByUser(User user);
}
