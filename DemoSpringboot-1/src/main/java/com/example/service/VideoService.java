package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.Video;

public interface VideoService {

	void deleteAll();

	void deleteById(Integer id);

	long count();

	Optional<Video> findById(Integer id);

	List<Video> findAll();

	<S extends Video> S save(S entity);

	Page<Video> findByCategoryId(Integer categoryId, Pageable pageable);

	Page<Video> findByTitleContainingIgnoreCase(String title, Pageable pageable);
	
	Page<Video> search(String keyword, Pageable pageable);

	void delete(Video entity);
	
	Page<Video> findAll(int page, int size, String keyword);
}
