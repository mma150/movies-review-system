package com.movies.review.system.ratings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movies.review.system.ratings.entity.RatingsEntity;

@Repository
public interface RatingsRepository extends JpaRepository<RatingsEntity, Long>{

	@Query("SELECT ratings FROM RatingsEntity ratings WHERE ratings.userId = ?1")
	public List<RatingsEntity> getAllRatings(Long userId);
}
