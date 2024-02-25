package com.w2m.service.metamodel;

import com.w2m.service.SpacecraftEntity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(SpacecraftEntity.class)
public class SpacecraftEntity_ {
	public static volatile SingularAttribute<SpacecraftEntity, String> name;
}
