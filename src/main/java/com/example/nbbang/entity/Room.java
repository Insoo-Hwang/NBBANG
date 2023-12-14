package com.example.nbbang.entity;

import com.example.nbbang.dto.RoomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String info;

    @Column
    private boolean show;

    @Column
    private String title;

    @Column
    private Long leader;

    public static Room createRoom(RoomDto dto) {
        return new Room(dto.getId(), dto.getInfo(), dto.isShow(), dto.getTitle(), dto.getLeader());
    }
}
