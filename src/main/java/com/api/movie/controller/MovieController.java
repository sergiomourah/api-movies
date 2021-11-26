package com.api.movie.controller;

import com.api.movie.entity.Movie;
import com.api.movie.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieController {

	MovieService service;

	@GetMapping("/")
	public ResponseEntity<List<Movie>> getAll() {
		return new ResponseEntity<>(service.getAll(), OK);
	}
}
