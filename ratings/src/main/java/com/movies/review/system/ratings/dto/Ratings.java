package com.movies.review.system.ratings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {
	private Long ratingId;
	private Long userId;
	private Long movieId;
	private Long rating;
	private String reviews;
}
