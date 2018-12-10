package br.com.abim.primo.repository;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.abim.primo.domain.Departamento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class DepartamentoService {

    private final Logger log = LoggerFactory.getLogger(DepartamentoService.class);

	@Autowired
	private  DepartamentoRepository departamentoRepository;
    
    public Departamento createDepartamento(String nome, Long id) {
    	Departamento departamento = new Departamento();
    	if(id!=null) {
        	departamento.setId(id);
    	}
    	departamento.setNome(nome);
    	departamento.setUf("MT");
    	Departamento resultado=departamentoRepository.save(departamento);
    	return resultado;
    } 	
    public Departamento createDepartamento(Departamento depto) {
    	Departamento resultado=departamentoRepository.save(depto);
    	return resultado;
    } 	
    public void deleteDepartamento(Long id) {
    	departamentoRepository.findById(id).ifPresent(depto -> {
    		departamentoRepository.delete(depto);
            log.debug("Deletado o Departamento: {}", depto);
        });
    }

}
