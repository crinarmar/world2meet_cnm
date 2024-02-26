package com.w2m.service.use_case;

import org.springframework.stereotype.Service;

import com.w2m.service.Spacecraft;
import com.w2m.service.repository.SpacecraftRepository;

@Service
public class DeleteSpacecraftImpl implements DeleteSpacecraft {

	private final SearchSpacecraft searchSpacecraft;
	private final SpacecraftRepository spacecraftRepository;

	public DeleteSpacecraftImpl(SearchSpacecraft searchSpacecraft, SpacecraftRepository spacecraftRepository) {
		this.searchSpacecraft = searchSpacecraft;
		this.spacecraftRepository = spacecraftRepository;
	}

	@Override
	public void deleteSpacecraft(Long id) {
		this.deleteSpacecraft(this.searchSpacecraft.searchSpacecraftById(id));

	}

	@Override
	public void deleteSpacecraft(Spacecraft spacecraft) {
		this.spacecraftRepository.delete(spacecraft);

	}
}
