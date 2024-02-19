package it.epicode.S7D1.exception;

public class LoginFaultException extends RuntimeException{

    public LoginFaultException(String message){
        super(message);
    }
}
