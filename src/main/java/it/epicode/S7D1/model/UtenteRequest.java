package it.epicode.S7D1.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteRequest {

    @NotBlank(message = "nome obbligatorio")
    private String nome;
    @NotBlank(message = "cognome obbligatorio")
    private String cognome;
    @NotBlank(message = "username obbligatorio")
    private String username;
    @NotBlank(message = "password obbligatoria")
    private String password;
}
