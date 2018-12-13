package br.com.abim.primo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.abim.primo.domain.Departamento;
import br.com.abim.primo.repository.DepartamentoRepository;
import br.com.abim.primo.repository.DepartamentoService;

/*
 * Teste usando service sem Mock
 * Para testar em um banco de teste (sem contaminar o banco principal, deve-se usar @DataJpaTest
 * Como não é possível injetar um service usando @DataJpaTest, há duas alernativas
 * 1.Usar @ComponentScan(basePackages = {"br.com.abim.primo"})
 * 2.@TestConfiguration
 */



@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"br.com.abim.primo"})
@DataJpaTest
public class DepartamentoServiceIntegrationInMemoryTest {

    private static final String DEFAULT_DEPARTAMENT_NAME = "kkkkkkkk";
 
/*    
    @TestConfiguration
    static class DepartamentoServiceTestContextConfiguration {
  
        @Bean
        public DepartamentoService departamentoService() {
            return new DepartamentoService();
        }
    }
*/ 
    @Autowired
    private DepartamentoRepository departamentoRepository;
  

	@Autowired
    private DepartamentoService departamentoService;
	
	private static final Departamento depto=new Departamento();
	
	
	@Test
	public void whenSaveDepartamento() {
	    String nome = DEFAULT_DEPARTAMENT_NAME;
	    depto.setNome(nome);
	    departamentoService.createDepartamento(depto);
	    Departamento deptoFound = departamentoRepository.findByNome(nome);
	    assertNotNull(deptoFound);
	 }

	

}
