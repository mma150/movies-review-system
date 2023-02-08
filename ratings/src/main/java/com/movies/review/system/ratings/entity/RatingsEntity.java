package com.movies.review.system.ratings.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cmn_ratings_mst")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ratingId;
	private Long userId;
	private Long movieId;
	private Long rating;
	private String reviews;
	private Short activeFlag;
	private Date createdDate;
}
