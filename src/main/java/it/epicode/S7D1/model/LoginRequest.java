package it.epicode.S7D1.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "username obbligatorio")
    private String username;
    @NotBlank(message = "password obbligatoria")
    private String password;
}
