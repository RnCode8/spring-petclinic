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

	@Test
	void testGetPetIgnoreNewAndCaseInsensitive() {
		Owner o = new Owner();
		Pet p = new Pet();
		p.setName("Bella");
		o.addPet(p);
		// name matching should be case-insensitive
		assertEquals(p, o.getPet("bella"));
		// if ignoreNew is true, new (unsaved) pets are ignored
		assertNull(o.getPet("bella", true));
	}

	@Test
	void testAddPetDoesNotAddWhenNotNew() {
		Owner o = new Owner();
		Pet existing = new Pet();
		existing.setId(5);
		existing.setName("Buddy");
		// pet is not new, addPet should NOT add it
		o.addPet(existing);
		assertTrue(o.getPets().isEmpty());
	}

}
