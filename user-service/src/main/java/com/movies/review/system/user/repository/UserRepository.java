package com.movies.review.system.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.review.system.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	//Custom query will be set here 
	public Optional<List<UserEntity>> findByUserNameContaining(String userName);
	
	public Optional<List<UserEntity>> findByUserEmailContaining(String userEmail);

}
