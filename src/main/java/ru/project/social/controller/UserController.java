package ru.project.social.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.project.social.dto.UserDto;
import ru.project.social.service.UserService;

@RestController
@RequestMapping("/rest/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createUser(@Valid @RequestBody UserDto user) {
       return userService.saveUser(user);
    }

}
