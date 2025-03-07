package br.com.lari;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.lari.model.Person;
import br.com.lari.service.IPersonService;
import br.com.lari.service.PersonService;

public class PersonServiceTest {
	
	Person person;
	
	IPersonService service;
	
	@BeforeEach
	void setup() {
		service = new PersonService();
		person =  new Person(
				"Larissa",
				"Moon",
				"larissa.silva@lari.com.br",
				"Morioka",
				"Feme"
				);
	}
	
	@Test
	@DisplayName("When criate a Person with Success Should Return a Person")
	void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
		
		// Given - Arrange
		
		// When - Act
		
		Person actual = service.createPerson(person);
		
		// Then - Assert
		
		assertNotNull(actual, () -> "The createPerson() should not have returned null");
	}
	
	@Test
	@DisplayName("When criate a Person with Success Should Contains Frist Name in Returned a Person")
	void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {
		
		// Given - Arrange
		
		// When - Act
		
		Person actual = service.createPerson(person);
		
		// Then - Assert
		assertNotNull(person.getId(), () -> "Person ID is Missing");
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The first name is incorrect");
		assertEquals(person.getLastName(), actual.getLastName(), () -> "The last name is incorrect");
		assertEquals(person.getEmail(), actual.getEmail(), () -> "The email is incorrect");
		assertEquals(person.getAddres(), actual.getAddres(), () -> "The Addres name is incorrect");
		assertEquals(person.getGender(), actual.getGender(), () -> "The gender name is incorrect");
	}
	
	@Test
	@DisplayName("When Create a Person with null email should throw Exception")
	void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {

		// Given - Arrange
		
		
		person.setEmail(null);
		
		var expectedMessage = "The Person email is null or empty";
		
		// When - Act & Then - Assert
		
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class, 
				() -> service.createPerson(person),
				() -> "Empty email should have cause an IllegalArgumentException"
				);
		
		// Then - Assert
		assertEquals(
				expectedMessage, 
				exception.getMessage(),
				() -> "Exception error message is incorrect!" 
				);
		
	}
	

}
