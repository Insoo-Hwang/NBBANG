package com.example.nbbang.dto;

import com.example.nbbang.entity.UserScheduleRelation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UserScheduleRelationDto {
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("schedule_id")
    private Long scheduleId;

    public static UserScheduleRelationDto createUserScheduleDto(UserScheduleRelation relation){
        return new UserScheduleRelationDto(relation.getId(), relation.getUser().getId(), relation.getSchedule().getId());
    }
}
