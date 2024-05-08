package ru.project.social.mapper;

import org.mapstruct.Mapper;
import ru.project.social.dto.PostDto;
import ru.project.social.entity.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostDto post);
}
