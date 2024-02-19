package it.epicode.S7D1.service;

import it.epicode.S7D1.exception.NotFoundException;
import it.epicode.S7D1.model.Utente;
import it.epicode.S7D1.model.UtenteRequest;
import it.epicode.S7D1.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

        @Autowired
        private UtenteRepository utenteRepository;

        public Utente save(UtenteRequest utenteRequest){

            Utente utente = new Utente();
            utente.setNome(utenteRequest.getNome());
            utente.setCognome(utenteRequest.getCognome());
            utente.setUsername(utenteRequest.getUsername());
            utente.setPassword(utenteRequest.getPassword());

            return utenteRepository.save(utente);
        }

        public Utente getUtenteById(int id){
            return utenteRepository.findById(id).orElseThrow(()->new NotFoundException("Utente non trovato"));
        }

        public Utente getUtenteByUsername(String username){
            return utenteRepository.findByUsername(username).orElseThrow(()->new NotFoundException("Username non trovato"));
        }
    }
