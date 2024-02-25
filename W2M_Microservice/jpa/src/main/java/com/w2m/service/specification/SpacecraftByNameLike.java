package com.w2m.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.w2m.service.SpacecraftEntity;

public class SpacecraftByNameLike {
	private final String name;

	public SpacecraftByNameLike(String name) {
		this.name = name;
	}

	public Specification<SpacecraftEntity> getSpecification() {

		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("name")),
				"%" + this.name.trim().toUpperCase() + "%");
	}
}
