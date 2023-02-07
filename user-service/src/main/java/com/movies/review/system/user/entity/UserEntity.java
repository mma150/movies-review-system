package com.movies.review.system.user.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cmn_user_mst")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long userId;
	
	@Column(name = "name")
	private String userName;
	
	@Column(name = "email")
	private String userEmail;
	
	@Column(name = "created_date")
	private Date createdDate = new Date();
	
	@Column(name="active_flag")
	private Short activeFlag = 1;
	
}
