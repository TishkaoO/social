package ru.project.social.service;

import ru.project.social.dto.PostDto;
import ru.project.social.dto.UserFilterDto;

import java.util.List;

public interface PostService {
    List<PostDto> getPostsByFilter(UserFilterDto filter);

    Long savePosts(PostDto post);

    void deletePost(Long id);
}
