package br.com.garbo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.garbo.converter.DozerConverter;
import br.com.garbo.data.model.Person;
import br.com.garbo.data.vo.v1.PersonVO;
import br.com.garbo.exception.ResourceNotFoundException;
import br.com.garbo.repository.PersonRepository;

@Service //Spring cuida da injecao de dependencia, desta maneira nao preciso instanciar ou deixar static 
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);		
		return vo;
	}		
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}	
	
	public PersonVO findById(Long id) {		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}	
	
	public List<PersonVO> findAll() {

		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}	
}
