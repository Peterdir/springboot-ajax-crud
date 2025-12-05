package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	// Tìm kiếm theo tên
	List<Category> findByCategoryNameContaining(String name);

	// Tìm kiếm theo tên có phân trang
	Page<Category> findByCategoryNameContaining(String name, Pageable pageable);
	Optional<Category> findByCategoryName(String name);
}