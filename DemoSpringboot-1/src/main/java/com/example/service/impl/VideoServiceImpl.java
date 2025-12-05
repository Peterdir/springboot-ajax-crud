package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entity.Video;
import com.example.repository.VideoRepository;
import com.example.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoRepository videoRepository;

	@Override
	public Page<Video> findByTitleContainingIgnoreCase(String title, Pageable pageable) {
		return videoRepository.findByTitleContainingIgnoreCase(title, pageable);
	}

	@Override
	public Page<Video> findByCategoryId(Integer categoryId, Pageable pageable) {
		return videoRepository.findByCategoryId(categoryId, pageable);
	}

	@Override
	public <S extends Video> S save(S entity) {
		return videoRepository.save(entity);
	}

	@Override
	public List<Video> findAll() {
		return videoRepository.findAll();
	}

	@Override
	public Optional<Video> findById(Integer id) {
		return videoRepository.findById(id);
	}

	@Override
	public long count() {
		return videoRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		videoRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		videoRepository.deleteAll();
	}
	
	@Override
    public Page<Video> search(String keyword, Pageable pageable) {
        if (keyword == null || keyword.isBlank()) {
            return videoRepository.findAll(pageable);
        }
        return videoRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

	@Override
	public void delete(Video entity) {
		videoRepository.delete(entity);
	}
	
	@Override
	public Page<Video> findAll(int page, int size, String keyword) {
	    Pageable pageable = PageRequest.of(page, size);

	    if (keyword == null || keyword.isBlank()) {
	        return videoRepository.findAll(pageable);
	    }
	    return videoRepository.findByTitleContainingIgnoreCase(keyword, pageable);
	}
}
