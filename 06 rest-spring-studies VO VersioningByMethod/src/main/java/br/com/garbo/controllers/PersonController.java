package br.com.garbo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.garbo.data.vo.PersonVO;
import br.com.garbo.data.vo.v2.PersonVOV2;
import br.com.garbo.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	
	@GetMapping
	public List<PersonVO> findAll() {		
		return services.findAll();
	}	
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {		
		return services.findById(id);
	}
		
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {		
		return services.create(person);
	}
	
	@PostMapping("/v2")
	public PersonVOV2 createv2(@RequestBody PersonVOV2 person) {		
		return services.create(person);
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) {		
		return services.update(person);
	}		
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {		
		services.delete(id);
		return ResponseEntity.ok().build();
	}	
}
