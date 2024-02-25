package com.w2m.service.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpacecraftCriteria {
	private final String name;

	public SpacecraftCriteria(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
