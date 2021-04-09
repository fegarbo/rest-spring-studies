package br.com.garbo.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

import br.com.garbo.data.vo.v1.PersonVO;
import br.com.garbo.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Person Endpoint", description = "Description for person", tags = {"PersonEndpoint"}) //description is deprecated
//@CrossOrigin //Allow access for all controller
@Api(tags = {"PersonEndpoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices services;
	
	//@CrossOrigin(origins= {"http://localhost:8080"}) //allowed only by local calls. I can specify more than one like: {"http://localhost:8080", "https://www.google.com"}
	@ApiOperation(value = "Find all persons recorded")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<PersonVO> findAll() {		
		List<PersonVO> persons = services.findAll();
		persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}	
	
	@ApiOperation(value = "Find a person record by ID")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO findById(@PathVariable("id") Long id) {		
		PersonVO personVO = services.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel()); //Adiciona um auto relacionamento (/api/person/v1 + findbyId)
		return personVO;
	}
	
	@ApiOperation(value = "Create a new person record")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
		    	 consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO create(@RequestBody PersonVO person) {		
		PersonVO personVO = services.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;		
	}
	
	@ApiOperation(value = "Update informations of a person record")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
			    consumes = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO update(@RequestBody PersonVO person) {		
		PersonVO personVO = services.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;		
	}		
	
	@ApiOperation(value = "Delete a person record by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {		
		services.delete(id);
		return ResponseEntity.ok().build();
	}	
}
