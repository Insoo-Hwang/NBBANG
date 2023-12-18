package com.example.nbbang.dto;

import com.example.nbbang.entity.UserRoomRelation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UserRoomRelationDto {

    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("room_id")
    private Long roomId;

    public static UserRoomRelationDto createUserRoomRelationDto(UserRoomRelation relation) {
        return new UserRoomRelationDto(relation.getId(), relation.getUser().getId(), relation.getRoom().getId());
    }
}
