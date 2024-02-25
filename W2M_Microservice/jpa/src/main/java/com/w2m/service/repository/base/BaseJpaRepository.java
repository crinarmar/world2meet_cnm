package com.w2m.service.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.w2m.service.SpacecraftEntity;

@Repository
public interface BaseJpaRepository extends JpaRepository<SpacecraftEntity, Long>, JpaSpecificationExecutor<SpacecraftEntity> {

}
