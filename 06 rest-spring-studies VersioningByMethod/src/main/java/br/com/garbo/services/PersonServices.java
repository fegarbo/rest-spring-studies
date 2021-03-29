package br.com.garbo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.garbo.converter.DozerConverter;
import br.com.garbo.converter.custom.PersonConverter;
import br.com.garbo.data.model.Person;
import br.com.garbo.data.vo.PersonVO;
import br.com.garbo.data.vo.v2.PersonVOV2;
import br.com.garbo.exception.ResourceNotFoundException;
import br.com.garbo.repository.PersonRepository;

@Service //Spring cuida da injecao de dependencia, desta maneira nao preciso instanciar ou deixar static 
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);		
		return vo;
	}		
	
	public PersonVOV2 create(PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person);
		var vo = converter.convertEntityToVO(repository.save(entity));		
		return vo;
	}		
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId())
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
