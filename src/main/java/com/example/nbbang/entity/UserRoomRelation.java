package com.example.nbbang.entity;

import com.example.nbbang.dto.UserRoomRelationDto;
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
public class UserRoomRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public static UserRoomRelation createUserRoomRelation(UserRoomRelationDto dto, User user, Room room) {
        return new UserRoomRelation(dto.getId(), user, room);
    }
}
