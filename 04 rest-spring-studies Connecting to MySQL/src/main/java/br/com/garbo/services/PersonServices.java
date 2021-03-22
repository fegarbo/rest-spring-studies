package br.com.garbo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.garbo.exception.ResourceNotFoundException;
import br.com.garbo.model.Person;
import br.com.garbo.repository.PersonRepository;

@Service //Spring cuida da injecao de dependencia, desta maneira nao preciso instanciar ou deixar static 
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}		
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}	
	
	public Person findById(Long id) {		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}	
	
	public List<Person> findAll() {

		return repository.findAll() ;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}	
}
