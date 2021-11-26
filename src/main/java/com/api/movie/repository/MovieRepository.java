package com.api.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.movie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
}
