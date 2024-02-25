package com.w2m.service.exception;

public class SpacecraftNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SpacecraftNotFoundException() {
		super("Nave no encontrada");
	}
}
