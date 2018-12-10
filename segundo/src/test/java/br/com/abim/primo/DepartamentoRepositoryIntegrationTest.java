package br.com.abim.primo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.abim.primo.domain.Departamento;
import br.com.abim.primo.repository.DepartamentoRepository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartamentoRepositoryIntegrationTest {
    
    private static final String DEFAULT_DEPARTAMENT_NAME = "kkkkkkkk";

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    
    
    @Test
    public void whenFindByName_thenReturnDefaultName() {
        // dado um departamento
        Departamento depto = new Departamento();
        depto.setNome(DEFAULT_DEPARTAMENT_NAME);
        entityManager.persist(depto);
        entityManager.flush();
        // Quando encontrado
        Departamento found = departamentoRepository.findByNome(depto.getNome());
        // então
		assertThat(found.getNome(), containsString(DEFAULT_DEPARTAMENT_NAME));
    }

}

