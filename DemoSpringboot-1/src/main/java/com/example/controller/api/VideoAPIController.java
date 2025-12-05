package com.example.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Video;
import com.example.service.VideoService;
import java.util.*;

@RestController
@RequestMapping("/api/videos")
public class VideoAPIController {

    @Autowired
    private VideoService videoService;

    // Lấy danh sách video có phân trang & tìm kiếm
    @GetMapping
    public ResponseEntity<?> getVideos(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(required = false) String keyword
    ) {
        Page<Video> videos = videoService.findAll(page, size, keyword);
        return ResponseEntity.ok(videos);
    }

    @PostMapping
    public ResponseEntity<?> addVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.save(video));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVideo(@PathVariable int id, @RequestBody Video video) {
        video.setId(id);
        return ResponseEntity.ok(videoService.save(video));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable int id) {
        videoService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
