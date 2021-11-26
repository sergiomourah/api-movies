package com.api.studio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.studio.entity.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long> {

}
