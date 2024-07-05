package org.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Authentication Request")
public class SignInRequest {

    private String username;
    private String password;
}
