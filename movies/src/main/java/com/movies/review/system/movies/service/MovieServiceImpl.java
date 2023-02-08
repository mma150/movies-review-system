package com.movies.review.system.movies.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.review.system.movies.dto.Movie;
import com.movies.review.system.movies.entity.MovieEntity;
import com.movies.review.system.movies.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie saveMovie(Movie movie) throws Exception {
		MovieEntity movieEntity = new MovieEntity();
		BeanUtils.copyProperties(movie, movieEntity);
		movieEntity = movieRepository.save(movieEntity);
		BeanUtils.copyProperties(movieEntity,movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Long id, Movie movie) throws Exception {
		MovieEntity movieEntity = movieRepository.findById(id).orElseThrow();
		if(movie.getMovieName()!=null && !movie.getMovieName().isEmpty())
			movieEntity.setMovieName(movie.getMovieName());
		if(movie.getMovieDesc()!=null && !movie.getMovieDesc().isEmpty())
			movieEntity.setMovieDesc(movie.getMovieDesc());
		if(movie.getActorDetails()!=null && !movie.getActorDetails().isEmpty())
			movieEntity.setActorDetails(movie.getActorDetails());
		
		movieRepository.save(movieEntity);
		BeanUtils.copyProperties(movieEntity,movie);
		return movie;
	}

	@Override
	public Movie deleteMovie(Long id) throws Exception {
		MovieEntity movieEntity = movieRepository.findById(id).orElseThrow();
		movieRepository.delete(movieEntity);
		Movie movie = new Movie();
		BeanUtils.copyProperties(movieEntity,movie);
		return movie;
	}

	@Override
	public Movie findMovieByMovieId(Long id) throws Exception {
		MovieEntity movieEntity = movieRepository.findById(id).orElseThrow();
		Movie movie = new Movie();
		BeanUtils.copyProperties(movieEntity, movie);
		return movie;
	}

	@Override
	public List<Movie> findMovieByMovieNamePattern(String name) throws Exception {
		List<MovieEntity> movieEntity = movieRepository.findByMovieNameContaining(name).orElseThrow();
		List<Movie> movieList = movieEntity.stream()
				.map(movie -> new Movie(movie.getMovieId(),movie.getMovieName(),movie.getMovieDesc(),movie.getActorDetails()))
				.collect(Collectors.toList());
		return movieList;
	}

	@Override
	public List<Movie> getAllMovieDetails() throws Exception {
		List<MovieEntity> movieEntity = movieRepository.findAll();
		List<Movie> movieList = movieEntity.stream()
				.map(movie -> new Movie(movie.getMovieId(),movie.getMovieName(),movie.getMovieDesc(),movie.getActorDetails()))
				.collect(Collectors.toList());
		return movieList;
	}

}
