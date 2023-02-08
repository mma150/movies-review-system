package com.movies.review.system.movies.service;

import java.util.List;

import com.movies.review.system.movies.dto.Movie;

public interface MovieService {

	//save movie details
	public Movie saveMovie(Movie movie) throws Exception;
	
	//update movie details
	public Movie updateMovie(Long id,Movie movie) throws Exception;
	
	//delete movie details
	public Movie deleteMovie(Long id) throws Exception;
	
	//search movie details
	public List<Movie> getAllMovieDetails() throws Exception;
	
	public Movie findMovieByMovieId(Long id) throws Exception;
	
	public List<Movie> findMovieByMovieNamePattern(String name) throws Exception;
}
