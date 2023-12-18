package com.example.nbbang.entity;

import com.example.nbbang.dto.ScheduleDto;
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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column
    private String date;

    @Column
    private int money;

    @Column
    private String info;

    public static Schedule createSchedule(ScheduleDto dto, Room room){
        return new Schedule(dto.getId(), room, dto.getDate(), dto.getMoney(), dto.getInfo());
    }

    public void patch(ScheduleDto dto){
        if(this.id != dto.getId()) throw new IllegalArgumentException();
        if(dto.getDate() != null) this.date = dto.getDate();
        this.money = dto.getMoney();
        if(dto.getInfo() != null) this.info = dto.getInfo();
    }
}
