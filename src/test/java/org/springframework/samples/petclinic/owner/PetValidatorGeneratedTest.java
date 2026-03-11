package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;

public class PetValidatorGeneratedTest {

	@Test
	void testValidateMissingFields() {
		Pet p = new Pet();
		p.setName("");
		p.setBirthDate(null);
		// new pet without type
		p.setId(null);

		PetValidator v = new PetValidator();
		Errors errors = new BeanPropertyBindingResult(p, "pet");
		v.validate(p, errors);
		assertTrue(errors.hasFieldErrors("name"));
		assertTrue(errors.hasFieldErrors("type"));
		assertTrue(errors.hasFieldErrors("birthDate"));
	}

	@Test
	void testSupports() {
		PetValidator v = new PetValidator();
		assertTrue(v.supports(Pet.class));
		assertFalse(v.supports(String.class));
	}

	@Test
	void testValidPetHasNoErrors() {
		Pet p = new Pet();
		p.setName("Spot");
		p.setBirthDate(LocalDate.of(2020, 5, 5));
		PetType t = new PetType();
		t.setName("Dog");
		p.setType(t);
		p.setId(null); // new pet

		PetValidator v = new PetValidator();
		Errors errors = new BeanPropertyBindingResult(p, "pet");
		v.validate(p, errors);
		assertFalse(errors.hasErrors());
	}

}
