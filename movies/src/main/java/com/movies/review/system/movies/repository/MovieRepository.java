package com.movies.review.system.movies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.review.system.movies.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>{

	//Custom Queries will be written here
	public Optional<List<MovieEntity>> findByMovieNameContaining(String name);
}
