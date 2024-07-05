package org.example.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Registration request")
public class SignUpRequest {

    @Schema(description = "Name of the user",example = "Dan")
    @Size(min = 5,max = 50,message = "Name of the user should contain from 5 to 50 symbols")
    @NotBlank(message = "Name shouldn't be empty")
    private String username;

    private String email;

    private String password;
}
