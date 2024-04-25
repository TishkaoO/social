package ru.project.social.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserDto {

    @NotBlank(message = "Username must be not empty")
    @Size(min = 4, max = 10, message = "minimum number of characters 6")
    private String username;

    @NotBlank(message = "Password must be not empty")
    @Size(min = 6, max = 14, message = "minimum number of characters 6")
    private String password;

    @Email(message = "Email must be valid")
    private String email;
}
