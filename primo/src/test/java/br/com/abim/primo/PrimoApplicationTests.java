package br.com.abim.primo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimoApplicationTests {

	@Autowired
	private OlaMundo olaMundo;

	@Autowired
	private  Main main;
	
	
	@Test
	public void contextLoads() {
		ApplicationContext ctx = SpringApplication.run(Main.class);
		assertNotNull(ctx);
	}
	
	@Test
	public void testBeanstNotNull() {
	    assertNotNull(olaMundo);
	}

	@Test
	public void testOlaMundo() {
		assertThat(olaMundo.digaOla(), containsString("Olá"));
	}

	@Test
	public void testMain() {
		assertThat(main,isA(Main.class));
		Main.main(new String[] {});
	}

}