package ru.project.social.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String name;
}
