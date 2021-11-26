package com.api.movie.service;

import com.api.movie.entity.Movie;
import com.api.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

	MovieRepository movieRepository;
	
	@Transactional
	public void saveMovies(List<Movie> movies) throws Exception {
		movies.forEach(movie -> movieRepository.save(movie));
	}
	
	public List<Movie> getAll() {
		return movieRepository.findAll();
	}
	
}
