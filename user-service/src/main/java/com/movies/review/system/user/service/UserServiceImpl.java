package com.movies.review.system.user.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.review.system.user.dto.UserBean;
import com.movies.review.system.user.entity.UserEntity;
import com.movies.review.system.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserBean saveUser(UserBean userBean) throws Exception {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userBean, userEntity);
		userEntity = userRepository.save(userEntity);
		BeanUtils.copyProperties(userEntity,userBean);
		return userBean;
	}

	@Override
	public List<UserBean> getAllUser() throws Exception {
		List<UserEntity> userList = userRepository.findAll();
		List<UserBean> userBeanList = userList
			.stream()
			.map(userBean -> new UserBean(userBean.getUserId(), userBean.getUserName(), userBean.getUserEmail()))
			.collect(Collectors.toList());
		return userBeanList;
	}

	@Override
	public UserBean getUserById(Long id) throws Exception {
		UserEntity entity = userRepository.findById(id).orElseThrow();
		UserBean userBean = new UserBean();
		BeanUtils.copyProperties(entity, userBean);
		return userBean;
	}

	@Override
	public List<UserBean> getUserByName(String name) throws Exception {
		List<UserEntity> entity = userRepository.findByUserNameContaining(name).orElseThrow();
		List<UserBean> userBeanList = entity
				.stream()
				.map(userBean -> new UserBean(userBean.getUserId(), userBean.getUserName(), userBean.getUserEmail()))
				.collect(Collectors.toList());
		
		return userBeanList;
	}

	@Override
	public List<UserBean> getUserByEmail(String email) throws Exception {
		List<UserEntity> entity = userRepository.findByUserEmailContaining(email).orElseThrow();
		List<UserBean> userBeanList = entity
				.stream()
				.map(userBean -> new UserBean(userBean.getUserId(), userBean.getUserName(), userBean.getUserEmail()))
				.collect(Collectors.toList());
		return userBeanList;
	}

	@Override
	public UserBean deleteUserById(Long id) throws Exception {
		UserEntity userEntity = userRepository.findById(id).orElseThrow();
		userRepository.delete(userEntity);
		UserBean userBean =  new UserBean();
		BeanUtils.copyProperties(userEntity, userBean);
		return userBean;
	}

	@Override
	public UserBean updateUser(Long id, UserBean userBean) throws Exception {
		UserEntity userEntity = userRepository.findById(id).orElseThrow();
		if(userBean.getUserName()!=null && !userBean.getUserName().isEmpty())
			userEntity.setUserName(userBean.getUserName());
		if(userBean.getUserEmail()!=null && !userBean.getUserEmail().isEmpty())
			userEntity.setUserEmail(userBean.getUserEmail());
		userRepository.save(userEntity);
		BeanUtils.copyProperties(userEntity,userBean);
		return userBean;
	}

}
