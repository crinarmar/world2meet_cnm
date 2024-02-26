package com.w2m.service.use_case;

import java.util.Collection;

import com.w2m.service.Spacecraft;

public interface SearchSpacecraft {
	Spacecraft searchSpacecraftById(Long id);

	Collection<Spacecraft> searchAllSpacecraft();

	Collection<Spacecraft> searchSpacecraftByFilter(String name);

}
