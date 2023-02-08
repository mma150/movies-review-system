package com.movies.review.system.movies.entity;

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
@Table(name = "cmn_movie_txn")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieId;
	private String movieName;
	private String movieDesc;
	private String actorDetails;
	private Short activeFlag = 1;
	private Date createdDate = new Date(); 

}
