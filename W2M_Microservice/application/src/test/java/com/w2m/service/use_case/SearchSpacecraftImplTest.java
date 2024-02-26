package com.w2m.service.use_case;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.w2m.service.Spacecraft;
import com.w2m.service.exception.SpacecraftNotFoundException;
import com.w2m.service.repository.SpacecraftRepository;

@ExtendWith(MockitoExtension.class)
public class SearchSpacecraftImplTest {

	@InjectMocks
	private SearchSpacecraftImpl searchSpacecraftImpl;

	@Mock
	private SpacecraftRepository spacecraftRepository;

	@Test
	void searchAllSpacecraft() {
		when(this.spacecraftRepository.findAll()).thenReturn(Collections.emptyList());
		assertEquals(0, this.searchSpacecraftImpl.searchAllSpacecraft().size());
	}

	@Test
	void searchById_SpacecraftNotFound() {
		when(this.spacecraftRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThrows(SpacecraftNotFoundException.class, () -> this.searchSpacecraftImpl.searchSpacecraftById(1L));
	}

	@Test
	void searchById() {
		when(this.spacecraftRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(Spacecraft.maker().id(1L).name("name").build()));
		assertEquals(1L, this.searchSpacecraftImpl.searchSpacecraftById(1L).getId());
	}

	@Test
	void searchSpacecraftByFilter() {
		Collection<Spacecraft> result = new ArrayList<>();
		result.add(Spacecraft.maker().id(1L).name("name").build());
		when(this.spacecraftRepository.findBy(Mockito.any())).thenReturn(result);

		assertEquals(1L, this.searchSpacecraftImpl.searchSpacecraftByFilter("name").size());
	}
}
