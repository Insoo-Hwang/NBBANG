package com.example.nbbang.repository;

import com.example.nbbang.entity.Schedule;
import com.example.nbbang.entity.User;
import com.example.nbbang.entity.UserScheduleRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserScheduleRelationRepository extends JpaRepository<UserScheduleRelation, Long> {

    List<UserScheduleRelation> findBySchedule(Schedule schedule);

    UserScheduleRelation findByUserAndSchedule(User user, Schedule schedule);

    @Modifying
    @Query(value = "DELETE FROM User_Schedule_Relation WHERE schedule_id = :scheduleId", nativeQuery = true)
    void deleteByScheduleId(Long scheduleId);
}
