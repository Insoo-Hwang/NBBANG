package com.example.nbbang.entity;

import com.example.nbbang.dto.UserScheduleRelationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserScheduleRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public static UserScheduleRelation createUserScheduleRelation(UserScheduleRelationDto dto, User user, Schedule schedule){
        return new UserScheduleRelation(dto.getId(), user, schedule);
    }
}
