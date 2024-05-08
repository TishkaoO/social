package ru.project.social.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.social.dto.PostDto;
import ru.project.social.dto.UserFilterDto;
import ru.project.social.entity.Post;
import ru.project.social.mapper.PostMapper;
import ru.project.social.repository.PostRepository;
import ru.project.social.service.PostService;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostDto> getPostsByFilter(UserFilterDto filter) {
        return postRepository.findPostsByFilter(filter.getUserId(), filter.getLimit(), filter.getOffset()).stream()
                .map(entity -> new PostDto(entity.getPostId(), entity.getName()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Long savePosts(PostDto post) {
        Post entity = postMapper.toEntity(post);
        return postRepository.save(entity).getPostId();
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    //TODO: реализовать отображение постов юзера по странично
    //можем видеть 10 первых постов после можем пропустить 10 и отобразить следующие 10
    //post должен вернуться с данными id, name

    //TODO: реализовать создание поста

    //TODO: реализовать удаление поста
}
