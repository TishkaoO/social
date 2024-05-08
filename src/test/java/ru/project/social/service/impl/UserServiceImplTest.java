package ru.project.social.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.project.social.dto.UserDto;
import ru.project.social.entity.Post;
import ru.project.social.entity.User;
import ru.project.social.repository.UserRepository;
import ru.project.social.service.UserService;
import java.util.Optional;


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
    void testUserMail() {
      UserDto userWithMail = createUser();
      userWithMail.setEmail("rgege");
      Long userMail = userService.saveUser(userWithMail);
      Optional<User> expected = userRepository.findById(userMail);
      Assert.assertEquals(expected.get().getEmail(), userWithMail.getEmail());
      Assert.assertEquals(expected.get().getEmail(), "erger");
    }

    @Test
    void testUserLogin() {
        UserDto userWithLogin = createUser();
        userWithLogin.setUsername("f");
        Long userLogin = userService.saveUser(userWithLogin);
        Optional<User> existingUser = userRepository.findById(userLogin);
        Assert.assertEquals(existingUser.isPresent(),true);
    }

    @Test
    void testUserParol() {
        UserDto userWithoutParol = createUser();
        userWithoutParol.setPassword("ggg");
        Long userParol = userService.saveUser(userWithoutParol);
        Optional<User> expected = userRepository.findById(userParol);
        Assert.assertEquals(expected.get().getPassword(),userWithoutParol.getPassword() );

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