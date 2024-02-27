package com.w2m.service.use_case;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.w2m.service.Spacecraft;
import com.w2m.service.criteria.SpacecraftCriteria;
import com.w2m.service.exception.SpacecraftNotFoundException;
import com.w2m.service.repository.SpacecraftRepository;

@Service
public class SearchSpacecraftImpl implements SearchSpacecraft {

	private final SpacecraftRepository spacecraftRepository;

	public SearchSpacecraftImpl(SpacecraftRepository spacecraftRepository) {
		this.spacecraftRepository = spacecraftRepository;
	}

	@Override
	@Cacheable(value = "spacecraftCache", key = "#id")
	public Spacecraft searchSpacecraftById(Long id) {
		Optional<Spacecraft> optionalSpacecraft = this.spacecraftRepository.findById(id);

		if (optionalSpacecraft.isEmpty()) {
			throw new SpacecraftNotFoundException();
		}

		Spacecraft spacecraft = optionalSpacecraft.get();
		return spacecraft;
	}

	@Override
	public Collection<Spacecraft> searchAllSpacecraft() {

		return this.spacecraftRepository.findAll().stream().collect(Collectors.toList());

	}

	@Override
	public Collection<Spacecraft> searchSpacecraftByFilter(String name) {
		return this.spacecraftRepository.findBy(new SpacecraftCriteria(name)).stream().collect(Collectors.toList());

	}

}
