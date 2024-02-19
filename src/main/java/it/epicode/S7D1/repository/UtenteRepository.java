package it.epicode.S7D1.repository;

import it.epicode.S7D1.model.Dipendente;
import it.epicode.S7D1.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{
    public Optional<Utente> findByUsername(String username);
}
