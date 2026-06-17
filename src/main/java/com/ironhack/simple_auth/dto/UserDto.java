package com.ironhack.simple_auth.dto;

import com.ironhack.simple_auth.model.User;

/**
 * Safe user info to send to the frontend.
 * Note what is NOT here: no password, no token.
 */
public record UserDto(Long id, String name, String email, String role) {

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
