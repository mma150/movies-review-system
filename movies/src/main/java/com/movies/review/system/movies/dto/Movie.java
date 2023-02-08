package com.movies.review.system.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	private Long movieId;
	private String movieName;
	private String movieDesc;
	private String actorDetails;
}
