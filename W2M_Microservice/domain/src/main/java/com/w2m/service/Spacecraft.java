package com.w2m.service;

import lombok.Getter;

@Getter
public class Spacecraft {
	private Long id;
	private String name;

	public static Builder maker() {
		return new Builder();
	}

	public static class Builder {
		private final Spacecraft spacecraft;

		private Builder() {
			this.spacecraft = new Spacecraft();
		}

		public Builder id(Long id) {
			spacecraft.id = id;
			return this;
		}

		public Builder name(String name) {
			spacecraft.name = name;
			return this;
		}

		public Spacecraft build() {
			return spacecraft;
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
