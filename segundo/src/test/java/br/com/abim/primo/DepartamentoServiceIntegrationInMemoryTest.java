package br.com.abim.primo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.abim.primo.domain.Departamento;
import br.com.abim.primo.repository.DepartamentoRepository;
import br.com.abim.primo.repository.DepartamentoService;

@RunWith(SpringRunner.class)
@DataJpaTest

public class DepartamentoServiceIntegrationInMemoryTest {

    private static final String DEFAULT_DEPARTAMENT_NAME = "kkkkkkkk";
    
    @TestConfiguration
    static class DepartamentoServiceTestContextConfiguration {
  
        @Bean
        public DepartamentoService departamentoService2() {
            return new DepartamentoService();
        }
    }
 
    @Autowired
    private DepartamentoRepository departamentoRepository;
  

	@Autowired
    private DepartamentoService departamentoService2;
	
	private static final Departamento depto=new Departamento();
	@Test
	public void whenSaveDepartamento() {
	    String nome = DEFAULT_DEPARTAMENT_NAME;
	    depto.setNome(nome);
	    departamentoService2.createDepartamento(depto);
	    Departamento deptoFound = departamentoRepository.findByNome(nome);
	    assertNotNull(deptoFound);
	 }

	

}
