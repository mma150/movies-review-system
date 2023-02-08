package com.movies.review.system.ratings.service;

import java.util.List;

import com.movies.review.system.ratings.dto.Ratings;

public interface RatingService {

	public Ratings saveRating(Ratings ratings) throws Exception;
	
	public List<Ratings> getAllRatingsFromUserId(Long userId) throws Exception;
}
