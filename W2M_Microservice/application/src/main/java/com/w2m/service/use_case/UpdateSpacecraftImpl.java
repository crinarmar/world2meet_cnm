package com.w2m.service.use_case;

import org.springframework.stereotype.Service;

import com.w2m.service.Spacecraft;
import com.w2m.service.repository.SpacecraftRepository;

@Service
public class UpdateSpacecraftImpl implements UpdateSpacecraft {

	private final SearchSpacecraft searchSpacecraft;
	private final SpacecraftRepository spacecraftRepository;

	public UpdateSpacecraftImpl(SearchSpacecraft searchSpacecraft, SpacecraftRepository spacecraftRepository) {
		this.searchSpacecraft = searchSpacecraft;
		this.spacecraftRepository = spacecraftRepository;
	}

	@Override
	public void updateSpacecraft(Spacecraft spacecraft) {
		this.searchSpacecraft.searchSpacecraftById(spacecraft.getId());
		this.spacecraftRepository.save(spacecraft);

	}

}
