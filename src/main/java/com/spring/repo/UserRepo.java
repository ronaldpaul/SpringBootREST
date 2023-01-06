package com.spring.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	@Override
	List<User> findAll();

}
