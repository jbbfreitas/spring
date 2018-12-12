package br.com.abim.primo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.abim.primo.OlaMundo;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Main.class, args);
		OlaMundo olaMundo = (OlaMundo) ctx.getBean("xxx");
		System.out.println(olaMundo.digaOla());
	}
}