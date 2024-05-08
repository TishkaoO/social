package ru.project.social.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.project.social.dto.PostDto;
import ru.project.social.dto.UserFilterDto;
import ru.project.social.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/filter")
    public List<PostDto> getPostsByFilter(@RequestBody UserFilterDto filter) {
        return postService.getPostsByFilter(filter);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createPost(@Valid @RequestBody PostDto post) {
        return postService.savePosts(post);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
