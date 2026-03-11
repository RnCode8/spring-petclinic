package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class VisitGeneratedTest {

	@Test
	void testDateAndDescriptionAccessors() {
		Visit v = new Visit();
		assertNotNull(v.getDate());
		LocalDate d = LocalDate.of(2021, 12, 25);
		v.setDate(d);
		assertEquals(d, v.getDate());
		v.setDescription("Checkup");
		assertEquals("Checkup", v.getDescription());
	}

	@Test
	void testDefaultDateIsToday() {
		Visit v = new Visit();
		assertNotNull(v.getDate());
		assertEquals(LocalDate.now(), v.getDate());
	}

}
