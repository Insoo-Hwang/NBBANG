package com.example.nbbang.repository;

import com.example.nbbang.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findById(Long id);

    Optional<Room> findByCode(String code);

    @Query(value = "SELECT * FROM room WHERE show = true", nativeQuery = true)
    List<Room> findByShow();
}
