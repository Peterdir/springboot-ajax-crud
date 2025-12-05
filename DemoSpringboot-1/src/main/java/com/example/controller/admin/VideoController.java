package com.example.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Video;
import com.example.service.VideoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/videos")
@RequiredArgsConstructor
public class VideoController {

	@Autowired
	VideoService videoService;

	@GetMapping
	public String list(Model model) {
		model.addAttribute("videos", videoService.findAll());
		return "video/list";
	}

	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("video", new Video());
		return "video/form";
	}

	@PostMapping
	public String save(@ModelAttribute Video video) {
		videoService.save(video);
		return "redirect:/admin/videos";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		Optional<Video> optionalVideo = videoService.findById(id);
		if (optionalVideo.isPresent()) {
			model.addAttribute("video", optionalVideo.get()); // ✅ giải Optional
		} else {
			// xử lý nếu không tìm thấy video
			return "redirect:/admin/videos";
		}
		return "video/edit";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		videoService.deleteById(id);
		return "redirect:/admin/videos";
	}
}
