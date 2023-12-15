package com.example.nbbang.dto;

import com.example.nbbang.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String nickname;

    public static UserDto createUserDto(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getPassword(), user.getNickname());
    }
}
