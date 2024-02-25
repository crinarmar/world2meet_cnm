package com.w2m.service.rest.controller.response.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.W2M.service.rest.interfaces.product.dto.SpacecraftRest;
import com.w2m.service.Spacecraft;

/**
 * Mapeador de objetos de dominio a objetos Rest
 * @author cnaranjo
 */
@Component
public class SpacecraftRestMapper {
	public SpacecraftRest mapTo(Spacecraft source) {
		Objects.requireNonNull(source);
		final SpacecraftRest SpacecraftRest = new SpacecraftRest(source.getId(), source.getName());
		return SpacecraftRest;
	}

	public List<SpacecraftRest> mapTo(Collection<Spacecraft> source) {
		Objects.requireNonNull(source);
		final List<SpacecraftRest> destinyCollection = new ArrayList<>();
		source.forEach(sourcePrice -> destinyCollection.add(this.mapTo(sourcePrice)));
		return destinyCollection;
	}

	public Spacecraft mapReverse(SpacecraftRest source) {
		Objects.requireNonNull(source);
		return Spacecraft.maker().id(source.getId()).name(source.getName()).build();
	}

}
