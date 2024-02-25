package com.w2m.service.repository;

import java.util.Collection;
import java.util.Optional;

import com.w2m.service.Spacecraft;
import com.w2m.service.criteria.SpacecraftCriteria;

public interface SpacecraftRepository {

	Collection<Spacecraft> findBy(SpacecraftCriteria criteria);

	Collection<Spacecraft> findAll();

	Optional<Spacecraft> findById(Long id);

	void save(Spacecraft spacecraft);

	void delete(Spacecraft spacecraft);

	void update(Spacecraft spacecraft);
}
