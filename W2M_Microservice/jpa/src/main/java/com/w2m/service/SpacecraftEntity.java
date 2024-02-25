package com.w2m.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SPACECRAFT")
public class SpacecraftEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Spacecraft_seq")
	@Column(name = "SPACECRAFT_ID", length = 9, nullable = false, unique = true)
	private Long id;

	@Column(name = "SPACECRAFT_NAME", length = 30, nullable = false, unique = false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
