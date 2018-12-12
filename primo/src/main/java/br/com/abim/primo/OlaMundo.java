package br.com.abim.primo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("xxx")
@Scope ("prototype")
public class OlaMundo {

    public String digaOla(){
        return "Olá Mundo. Eu sou um bean do Spring";
    }
}