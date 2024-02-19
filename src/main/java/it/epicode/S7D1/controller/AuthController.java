package it.epicode.S7D1.controller;

import it.epicode.S7D1.exception.BadRequestException;
import it.epicode.S7D1.exception.LoginFaultException;
import it.epicode.S7D1.model.LoginRequest;
import it.epicode.S7D1.model.Utente;
import it.epicode.S7D1.model.UtenteRequest;
import it.epicode.S7D1.security.JwtTools;
import it.epicode.S7D1.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private JwtTools jwtTools;
    @PostMapping("/auth/register")
    public Utente register(@RequestBody @Validated UtenteRequest utenteRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return utenteService.save(utenteRequest);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        Utente utente = utenteService.getUtenteByUsername(loginRequest.getUsername());

        if(utente.getPassword().equals(loginRequest.getPassword())){
            return jwtTools.createToken(utente);
        }
        else{
            throw new LoginFaultException("username/password errate");
        }

    }
}