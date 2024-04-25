package ru.project.social.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.social.dto.UserDto;
import ru.project.social.entity.User;
import ru.project.social.mapper.UserMapper;
import ru.project.social.repository.UserRepository;
import ru.project.social.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public Long saveUser(UserDto user) {
        User entity = userMapper.toEntity(user);
        return userRepository.save(entity).getId();
    }
}
