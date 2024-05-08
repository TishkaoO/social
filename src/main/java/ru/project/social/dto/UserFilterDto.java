package ru.project.social.dto;

import lombok.Data;

@Data
public class UserFilterDto {
    private Long userId;
    private Integer limit;
    private Integer offset;
}
