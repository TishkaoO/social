package ru.project.social.service;

import ru.project.social.dto.UserDto;

public interface UserService {
    Long saveUser(UserDto user);
}
