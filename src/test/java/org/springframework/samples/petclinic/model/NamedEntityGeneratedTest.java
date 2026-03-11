package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NamedEntityGeneratedTest {

	@Test
	void testNameAndToString() {
		NamedEntity n = new NamedEntity();
		assertEquals("<null>", n.toString());
		n.setName("Fido");
		assertEquals("Fido", n.getName());
		assertEquals("Fido", n.toString());
	}

}
