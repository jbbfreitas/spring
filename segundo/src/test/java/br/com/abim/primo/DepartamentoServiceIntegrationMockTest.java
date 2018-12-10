package br.com.abim.primo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.abim.primo.domain.Departamento;
import br.com.abim.primo.repository.DepartamentoRepository;
import br.com.abim.primo.repository.DepartamentoService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DepartamentoServiceIntegrationMockTest {

    private static final String DEFAULT_DEPARTAMENT_NAME = "kkkkkkkk";
	private static final Departamento depto=new Departamento();
    
    @TestConfiguration
    static class DepartamentoServiceTestContextConfiguration {
  
        @Bean
        public DepartamentoService departamentoService2() {
            return new DepartamentoService();
        }
    }
 
  
	@MockBean
    private DepartamentoRepository departamentoRepository;

	@Autowired
    private DepartamentoService departamentoService2;

	
	@Autowired
	private OlaMundo olaMundo;
	
	@Before
	public void setUp() {
	    depto.setNome(DEFAULT_DEPARTAMENT_NAME);
	    Mockito.when(departamentoRepository.save(depto))
	      .thenReturn(depto);
	}
	
	@Test
	public void testBeanstNotNull() {
	    assertNotNull(olaMundo);
	}

	@Test
	public void whenCreateDepartamento() {
	    Departamento deptoReturned = departamentoService2.createDepartamento(depto);
	    assertNotNull(deptoReturned.getNome());
	 }

	

}
