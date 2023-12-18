package com.example.nbbang.repository;

import com.example.nbbang.entity.Article;
import com.example.nbbang.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "SELECT * FROM schedule WHERE room_id = :roomId", nativeQuery = true)
    List<Schedule> findByRoomId(Long roomId);
}
