package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.User;

public interface UserService {

	void deleteAll();

	void deleteById(Integer id);

	Optional<User> findById(Integer id);

	List<User> findAll();

	<S extends User> S save(S entity);

}
