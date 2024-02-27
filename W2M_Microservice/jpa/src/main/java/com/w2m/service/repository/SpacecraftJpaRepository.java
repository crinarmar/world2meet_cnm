package com.w2m.service.repository;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.w2m.service.Spacecraft;
import com.w2m.service.SpacecraftEntity;
import com.w2m.service.criteria.SpacecraftCriteria;
import com.w2m.service.mapper.SpacecraftMapper;
import com.w2m.service.repository.base.BaseJpaRepository;
import com.w2m.service.specification.SpacecraftByNameLike;

@Repository
public class SpacecraftJpaRepository implements SpacecraftRepository {
	private final BaseJpaRepository baseRepository;
	private final SpacecraftMapper mapper;

	public SpacecraftJpaRepository(BaseJpaRepository repository, SpacecraftMapper mapper) {
		this.baseRepository = repository;
		this.mapper = mapper;
	}

	@Override
	public Collection<Spacecraft> findAll() {
		return this.mapper.mapTo(this.baseRepository.findAll());
	}

	@Override
	public Optional<Spacecraft> findById(Long id) {

		final Optional<SpacecraftEntity> optionalEntity = this.baseRepository.findById(id);

		if (optionalEntity.isEmpty()) {
			return Optional.empty();
		}

		return Optional.of(this.mapper.mapTo(optionalEntity.get()));
	}

	@Override
	public void save(Spacecraft source) {
		this.baseRepository.save(this.mapper.mapReverse(source));
	}

	@Override
	public void delete(Spacecraft source) {
		this.baseRepository.delete(this.mapper.mapReverse(source));

	}

	@Override
	public void update(Spacecraft source) {
		this.baseRepository.save(this.mapper.mapReverse(source));
	}

	@Override
	public Collection<Spacecraft> findBy(SpacecraftCriteria criteria) {
		return this.mapper.mapTo(this.baseRepository.findAll(this.getCriteriaSpecification(criteria)));
	}

	private Specification<SpacecraftEntity> getCriteriaSpecification(SpacecraftCriteria criteria) {

		Specification<SpacecraftEntity> specification = Specification.where(null);

		if (Objects.nonNull(criteria.getName())) {
			specification = specification.and(new SpacecraftByNameLike(criteria.getName()).getSpecification());
		}

		return specification;
	}

}
