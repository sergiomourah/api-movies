package com.api.extract;

import com.api.file.CsvFile;
import com.api.movie.entity.Movie;
import com.api.movie.service.MovieService;
import com.api.producer.entity.Producer;
import com.api.studio.entity.Studio;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log
@Service
@AllArgsConstructor
public class extractCsv {
	
	private static final String PATH = "file/movielist.csv";
	private static final String COMMA = ", ";
	private static final char SEMICOLON = ';';
	private static final String AND = " and ";

	private MovieService movieService;

	public void run() {
		try {
			
			List<CsvFile> moviesCsv = this.readFile();
			if(!moviesCsv.isEmpty()) {
				movieService.saveMovies(this.extractMovieByFile(moviesCsv));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<CsvFile> readFile() throws IOException, URISyntaxException {
		URI uri = ClassLoader.getSystemResource(PATH).toURI();
		Path path = Paths.get(uri);
			
		Reader reader = Files.newBufferedReader(path);
		List<CsvFile> moviesCsv = new CsvToBeanBuilder(reader)
			.withType(CsvFile.class)
			.withSkipLines(1)
			.withSeparator(SEMICOLON)
			.build()
			.parse();
		
		return moviesCsv;
		
	}
	
	private List<Movie> extractMovieByFile(List<CsvFile> moviesCsv) throws Exception {
		List<Movie> movies = new ArrayList<>();
		
		moviesCsv.forEach(csvFile -> {
			Movie movie = new Movie();
			movie.setTitle(csvFile.getTitle());
			movie.setYear(csvFile.getYear());
			movie.setWinner(csvFile.isWinner());
			movie.setProducers(extraxtProducer(movie, csvFile.getProducers()));
			movie.setStudios(extractStudio(movie, csvFile.getStudios()));
			movies.add(movie);
		});
		
		return movies;
	}
	
	private List<Producer> extraxtProducer (Movie movie, String producersCsvFile) {
		List<Producer> producers = new ArrayList<>();
		Arrays.asList(producersCsvFile.replaceAll(AND, COMMA).split(COMMA)).forEach(produceCsv -> {
			Producer producer = new Producer();
			producer.setName(produceCsv);
			producer.setMovie(movie);
			producers.add(producer);
		});
		return producers;
	}
	
	private List<Studio> extractStudio (Movie movie, String studiosMovieCsv) {
		List<Studio> studios = new ArrayList<>();
		Arrays.asList(studiosMovieCsv.split(COMMA)).forEach(produceCsv -> {
			Studio studio = new Studio();
			studio.setName(produceCsv);
			studio.setMovie(movie);
			studios.add(studio);
		});
		return studios;
	}
}