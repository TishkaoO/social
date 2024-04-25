package ru.project.social.mapper;

import org.mapstruct.Mapper;
import ru.project.social.dto.UserDto;
import ru.project.social.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto user);
}
