package com.w2m.service.rest.controller.response.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.W2M.service.rest.interfaces.spacecraft.dto.SpaceCraftRest;
import com.w2m.service.Spacecraft;

/**
 * Mapeador de objetos de dominio a objetos Rest
 * @author cnaranjo
 */
@Component
public class SpacecraftRestMapper {
	public SpaceCraftRest mapTo(Spacecraft source) {
		Objects.requireNonNull(source);
		final SpaceCraftRest SpacecraftRest = new SpaceCraftRest(source.getId(), source.getName());
		return SpacecraftRest;
	}

	public List<SpaceCraftRest> mapTo(Collection<Spacecraft> source) {
		Objects.requireNonNull(source);
		final List<SpaceCraftRest> destinyCollection = new ArrayList<>();
		source.forEach(sourcePrice -> destinyCollection.add(this.mapTo(sourcePrice)));
		return destinyCollection;
	}

	public Spacecraft mapReverse(SpaceCraftRest source) {
		Objects.requireNonNull(source);
		return Spacecraft.maker().id(source.getId()).name(source.getName()).build();
	}

}
