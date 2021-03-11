package br.com.garbo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.garbo.model.Person;

@Service //Spring cuida da injecao de dependencia, desta maneira nao preciso instanciar ou deixar static 
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();	

	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet()); //Gera um numero e incrementa
		person.setFirstName("Fernando");
		person.setLastName("Garbo");
		person.setAddress("São Paulo - Brasil");
		person.setGender("Male");
		return person ;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet()); //Gera um numero e incrementa
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address - Brasil " + i);
		person.setGender("Male");
		return person ;
	}	
}
