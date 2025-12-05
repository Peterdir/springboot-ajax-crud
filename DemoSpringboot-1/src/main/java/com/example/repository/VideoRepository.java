package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
	Page<Video> findByTitleContainingIgnoreCase(String title, Pageable pageable);
	Page<Video> findByCategoryId(Integer categoryId, Pageable pageable);
}
