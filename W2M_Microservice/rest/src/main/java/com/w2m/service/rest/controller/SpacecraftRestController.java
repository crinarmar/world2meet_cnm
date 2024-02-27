package com.w2m.service.rest.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.W2M.service.rest.interfaces.spacecraft.NavesApi;
import com.W2M.service.rest.interfaces.spacecraft.dto.SpaceCraftRest;
import com.w2m.service.rest.controller.response.mapper.SpacecraftRestMapper;
import com.w2m.service.use_case.CreateSpacecraft;
import com.w2m.service.use_case.DeleteSpacecraft;
import com.w2m.service.use_case.SearchSpacecraft;
import com.w2m.service.use_case.UpdateSpacecraft;

@RestController
public class SpacecraftRestController implements NavesApi {
	private final SearchSpacecraft searchSpacecraft;
	private final CreateSpacecraft createSpacecraft;
	private final DeleteSpacecraft deleteSpacecraft;
	private final UpdateSpacecraft updateSpacecraft;
	private final SpacecraftRestMapper mapper;

	public SpacecraftRestController(SearchSpacecraft searchSpacecraft, SpacecraftRestMapper mapper, CreateSpacecraft createSpacecraft,
			DeleteSpacecraft deleteSpacecraft, UpdateSpacecraft updateSpacecraft) {

		this.searchSpacecraft = searchSpacecraft;
		this.createSpacecraft = createSpacecraft;
		this.deleteSpacecraft = deleteSpacecraft;
		this.updateSpacecraft = updateSpacecraft;

		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<SpaceCraftRest>> listSpaceCrafts() {
		return ResponseEntity.ok(this.mapper.mapTo(this.searchSpacecraft.searchAllSpacecraft()));

	}

	@Override
	public ResponseEntity<Void> createSpaceCraft(SpaceCraftRest spacecraftRest) {
		Objects.nonNull(spacecraftRest);
		this.createSpacecraft.createSpacecraft(this.mapper.mapReverse(spacecraftRest));
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}

	@Override
	public ResponseEntity<SpaceCraftRest> findSpaceCraftById(Long id) {
		Objects.nonNull(id);
		return ResponseEntity.ok(this.mapper.mapTo(this.searchSpacecraft.searchSpacecraftById(id)));
	}

	@Override
	public ResponseEntity<Void> deleteSpaceCraftById(Long id) {
		Objects.nonNull(id);
		this.deleteSpacecraft.deleteSpacecraft(id);
		return ResponseEntity.status(HttpStatusCode.valueOf(202)).build();
	}

	@Override
	public ResponseEntity<Void> updateSpaceCraft(Long id, SpaceCraftRest spacecraftRest) {
		Objects.nonNull(id);
		Objects.nonNull(spacecraftRest);
		this.updateSpacecraft.updateSpacecraft(this.mapper.mapReverse(spacecraftRest));
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}

	@Override
	public ResponseEntity<List<SpaceCraftRest>> listSpaceCraftsByFilter(String name) {
		return ResponseEntity.ok(this.mapper.mapTo(this.searchSpacecraft.searchSpacecraftByFilter(name)));
	}

}
