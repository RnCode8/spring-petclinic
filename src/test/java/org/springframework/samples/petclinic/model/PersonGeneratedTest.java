package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonGeneratedTest {

	@Test
	void testNameAccessors() {
		Person p = new Person();
		p.setFirstName("John");
		p.setLastName("Doe");
		assertEquals("John", p.getFirstName());
		assertEquals("Doe", p.getLastName());
		// BaseEntity behavior
		assertTrue(p.isNew());
		p.setId(123);
		assertFalse(p.isNew());
	}

}
