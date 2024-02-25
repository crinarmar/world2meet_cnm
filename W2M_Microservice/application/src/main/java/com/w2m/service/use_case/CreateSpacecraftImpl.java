package com.w2m.service.use_case;

import org.springframework.stereotype.Service;

import com.w2m.service.Spacecraft;
import com.w2m.service.repository.SpacecraftRepository;

@Service
public class CreateSpacecraftImpl implements CreateSpacecraft {

	private final SpacecraftRepository spacecraftRepository;

	public CreateSpacecraftImpl(SpacecraftRepository spacecraftRepository) {
		this.spacecraftRepository = spacecraftRepository;
	}

	@Override
	public void createSpacecraft(Spacecraft spacecraft) {
		this.spacecraftRepository.save(spacecraft);

	}

}
