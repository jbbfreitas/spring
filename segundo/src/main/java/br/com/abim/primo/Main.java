package br.com.abim.primo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import br.com.abim.primo.OlaMundo;
import br.com.abim.primo.domain.Departamento;
import br.com.abim.primo.repository.DepartamentoService;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Main.class, args);
		OlaMundo olaMundo = (OlaMundo) ctx.getBean("olaMundo");
		System.out.println(olaMundo.digaOla());
		DepartamentoService departamentoService = (DepartamentoService)ctx.getBean("departamentoService");
		Departamento depto1 =departamentoService.createDepartamento("Departamento criado com o nome",null);
		System.out.println("===========Criando com nome======== ");
		System.out.println(depto1);
		//Usando o método que recebe uma instância de departamento
		Departamento depto = new Departamento();
		depto.setNome("Departamnto criado com a instância");
		depto.setUf("GO");
		Departamento depto2 =departamentoService.createDepartamento(depto);
		System.out.println("===========Criando com a instância======== ");
		System.out.println(depto2);
	}
}
 