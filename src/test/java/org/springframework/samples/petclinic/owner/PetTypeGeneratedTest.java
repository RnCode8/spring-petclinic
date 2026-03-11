package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PetTypeGeneratedTest {

	@Test
	void testNameInheritance() {
		PetType pt = new PetType();
		assertNull(pt.getName());
		pt.setName("Parrot");
		assertEquals("Parrot", pt.getName());
		assertEquals("Parrot", pt.toString());
	}

}
