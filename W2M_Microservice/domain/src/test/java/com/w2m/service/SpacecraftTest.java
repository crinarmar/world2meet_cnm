package com.w2m.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpacecraftTest {

	@Test
	void test() {
		Spacecraft spacecraft = Spacecraft.maker().id(1L).name("test").build();
		assertNotNull(spacecraft.getId());
		assertNotNull(spacecraft.getName());
	}

}
