package com.movies.review.system.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.review.system.movies.dto.Movie;
import com.movies.review.system.movies.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public ResponseEntity<Movie> saveMovieDetails(@RequestBody Movie movie) throws Exception {
		return new ResponseEntity<Movie>(movieService.saveMovie(movie),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMoviesDetails() throws Exception{
		return new ResponseEntity<List<Movie>>(movieService.getAllMovieDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) throws Exception{
		return new ResponseEntity<Movie>(movieService.findMovieByMovieId(id),HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Movie>> getMovieByMovieName(@PathVariable String name) throws Exception{
		return new ResponseEntity<List<Movie>>(movieService.findMovieByMovieNamePattern(name),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateMovieDetails(@PathVariable Long id, @RequestBody Movie movie) throws Exception{
		return new ResponseEntity<Movie>(movieService.updateMovie(id, movie),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Movie> deleteMovieDetails(@PathVariable Long id) throws Exception{
		return new ResponseEntity<Movie>(movieService.deleteMovie(id),HttpStatus.OK);
	}
} 
