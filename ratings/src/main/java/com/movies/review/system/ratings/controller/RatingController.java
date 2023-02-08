package com.movies.review.system.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.review.system.ratings.dto.Ratings;
import com.movies.review.system.ratings.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/user/{userId}/movies/{movieId}/ratings")
	public ResponseEntity<Ratings> saveRatings(@PathVariable Long userId,@PathVariable Long movieId, @RequestBody Ratings ratings) throws Exception{
		ratings.setUserId(userId);
		ratings.setMovieId(movieId);
		return new ResponseEntity<Ratings>(ratingService.saveRating(ratings),HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}/ratings")
	public ResponseEntity<List<Ratings>> getAllRatingsFromUserId(@PathVariable Long userId) throws Exception{
		return new ResponseEntity<List<Ratings>>(ratingService.getAllRatingsFromUserId(userId),HttpStatus.OK);
	}
}
