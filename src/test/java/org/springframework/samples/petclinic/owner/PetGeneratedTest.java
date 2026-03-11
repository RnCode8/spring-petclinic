package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;

import java.time.LocalDate;

public class PetGeneratedTest {

	@Test
	void testPetAccessors() {
		Pet p = new Pet();
		p.setBirthDate(LocalDate.of(2020, 1, 1));
		assertEquals(LocalDate.of(2020, 1, 1), p.getBirthDate());
		PetType t = new PetType();
		t.setName("Dog");
		p.setType(t);
		assertEquals("Dog", p.getType().getName());
	}

}
