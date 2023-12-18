package com.example.nbbang.dto;

import com.example.nbbang.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ScheduleDto {

    private Long id;

    @JsonProperty("room_id")
    private Long roomId;

    private String date;

    private int money;

    private String info;

    public static ScheduleDto createScheduleDto(Schedule schedule){
        return new ScheduleDto(schedule.getId(), schedule.getRoom().getId(), schedule.getDate(), schedule.getMoney(), schedule.getInfo());
    }
}
