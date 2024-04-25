package ru.project.social.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.project.social.dto.UserDto;
import ru.project.social.entity.User;
import ru.project.social.repository.UserRepository;
import ru.project.social.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @Before
    public void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    void saveUser() {
        UserDto user = createUser();
        Long resultId = userService.saveUser(user);
        Optional<User> expected = userRepository.findById(resultId);
        Assert.assertEquals(expected.get().getId(), resultId);
        Assert.assertEquals(expected.isPresent(), true);
    }

    private UserDto createUser() {
       return UserDto.builder()
               .username("username")
               .password("password1")
               .build();
    }
}