package com.movies.review.system.ratings.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.review.system.ratings.dto.Ratings;
import com.movies.review.system.ratings.entity.RatingsEntity;
import com.movies.review.system.ratings.repository.RatingsRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingsRepository ratingsRepository;
	
	@Override
	public Ratings saveRating(Ratings ratings) throws Exception {
		RatingsEntity ratingsEntity = new RatingsEntity();
		BeanUtils.copyProperties(ratings, ratingsEntity);
		ratingsEntity = ratingsRepository.save(ratingsEntity);
		BeanUtils.copyProperties(ratingsEntity,ratings);
		return ratings;
	}

	@Override
	public List<Ratings> getAllRatingsFromUserId(Long userId) throws Exception {
		List<RatingsEntity> ratingsEntities = ratingsRepository.getAllRatings(userId);
		List<Ratings> ratingsList = ratingsEntities.stream()
				.map(ratings -> new Ratings(ratings.getRatingId(),ratings.getUserId(),ratings.getMovieId(),ratings.getRating(),ratings.getReviews()))
				.collect(Collectors.toList());
		return ratingsList;
	}

}
