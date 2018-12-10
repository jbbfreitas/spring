package br.com.abim.primo;

import org.springframework.stereotype.Component;

@Component
public class OlaMundo {

    public String digaOla(){
       return "Olá Mundo. Eu sou um bean do Spring";
    }
}