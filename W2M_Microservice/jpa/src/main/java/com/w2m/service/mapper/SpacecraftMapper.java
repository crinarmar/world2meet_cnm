package com.w2m.service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.w2m.service.Spacecraft;
import com.w2m.service.SpacecraftEntity;

/**
 * Mapper from entity SpacecraftEntity to domain Spacecraft
 * @author cnaranjo
 */
@Component
public class SpacecraftMapper {
	public Collection<Spacecraft> mapTo(Collection<SpacecraftEntity> sourceCollection) {

		if (Objects.isNull(sourceCollection) || sourceCollection.isEmpty()) {
			return Collections.emptyList();
		}

		final Collection<Spacecraft> result = new ArrayList<>();
		sourceCollection.forEach(spacecraftEntity -> result.add(this.mapTo(spacecraftEntity)));
		return result;
	}

	public Spacecraft mapTo(SpacecraftEntity source) {
		return Spacecraft.maker().id(source.getId()).name(source.getName()).build();
	}

	public SpacecraftEntity mapReverse(Spacecraft source) {
		final SpacecraftEntity spacecraftEntity = new SpacecraftEntity();
		spacecraftEntity.setId(source.getId());
		spacecraftEntity.setName(source.getName());
		return spacecraftEntity;
	}
}
