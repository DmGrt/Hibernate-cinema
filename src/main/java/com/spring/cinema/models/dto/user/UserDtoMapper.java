package com.spring.cinema.models.dto.user;

import com.spring.cinema.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
