package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static org.mockito.Mockito.*;

public class PetTypeFormatterGeneratedTest {

	@Test
	void testPrintHandlesNullName() {
		PetType pt = new PetType();
		PetTypeFormatter f = new PetTypeFormatter(mock(PetTypeRepository.class));
		assertEquals("<null>", f.print(pt, Locale.ENGLISH));
	}

	@Test
	void testParseFindsMatchingType() throws ParseException {
		PetType t1 = new PetType();
		t1.setName("Cat");
		PetType t2 = new PetType();
		t2.setName("Dog");

		PetTypeRepository repo = mock(PetTypeRepository.class);
		when(repo.findPetTypes()).thenReturn(List.of(t1, t2));

		PetTypeFormatter f = new PetTypeFormatter(repo);
		PetType res = f.parse("Dog", Locale.ENGLISH);
		assertNotNull(res);
		assertEquals("Dog", res.getName());
	}

}
