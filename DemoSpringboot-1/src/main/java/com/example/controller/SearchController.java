package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.VideoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {

	@Autowired
	VideoService videoService;
	
	@GetMapping("/search")
    public String search(@RequestParam(required = false) String q, Pageable pageable, Model model) {
        model.addAttribute("page", videoService.search(q, pageable));
        model.addAttribute("q", q);
        return "search";
    }
}
