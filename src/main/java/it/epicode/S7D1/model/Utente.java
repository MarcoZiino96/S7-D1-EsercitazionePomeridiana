package it.epicode.S7D1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String cognome;

    @Column(unique = true)
    private String username;
    private String password;


}
