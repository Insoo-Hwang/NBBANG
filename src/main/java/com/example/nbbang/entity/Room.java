package com.example.nbbang.entity;

import com.example.nbbang.dto.RoomDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

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

    @Column
    private String code;

    @PrePersist
    public void createCode(){
        String randomcode = UUID.randomUUID().toString().replaceAll("-", "");
        code = randomcode;
    }

    public static Room createRoom(RoomDto dto) {
        return new Room(dto.getId(), dto.getInfo(), dto.isShow(), dto.getTitle(), dto.getLeader(), dto.getCode());
    }
}
