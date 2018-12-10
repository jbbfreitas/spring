package br.com.abim.primo;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PrmeiroApplicationTests {

	
	@Test
	public void digaOlaTest() {
		ApplicationContext ctx = SpringApplication.run(Main.class);
		OlaMundo olaMundo = (OlaMundo) ctx.getBean("olaMundo");
		assertThat(olaMundo.digaOla(), containsString("Eu sou um bean do Spring"));
	}



}
