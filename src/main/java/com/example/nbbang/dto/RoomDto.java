package com.example.nbbang.dto;

import com.example.nbbang.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RoomDto {
    private Long id;
    private String info;
    private boolean show;
    private String title;
    private Long leader;

    public static RoomDto createRoomDto(Room room) {
        return new RoomDto(room.getId(), room.getInfo(), room.isShow(), room.getTitle(), room.getLeader());
    }
}
