package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.Visit;

public class OwnerGeneratedTest {

	@Test
	void testAddAndFindPet() {
		Owner o = new Owner();
		Pet p1 = new Pet();
		p1.setName("Rex");
		assertTrue(o.getPets().isEmpty());
		o.addPet(p1);
		assertEquals(p1, o.getPet("Rex"));

		p1.setId(42);
		assertEquals(p1, o.getPet(42));

		// test addVisit via addVisit(Integer, Visit)
		Pet p2 = new Pet();
		p2.setName("Mittens");
		o.addPet(p2);
		p2.setId(100);
		Visit v = new Visit();
		o.addVisit(100, v);
		assertTrue(p2.getVisits().contains(v));
	}

}
