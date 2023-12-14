package com.example.nbbang.repository;

import com.example.nbbang.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findById(Long id);
    Optional<Room> findByCode(String code);
}
