package com.example.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Category;
import com.example.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping
	public String list(Model m, @PageableDefault(size = 10, sort = "categoryName") Pageable p) {
		m.addAttribute("page", categoryService.findAll(p));
		return "category/list";
	}

	@GetMapping("/new")
	public String createForm(Model m) {
		m.addAttribute("category", new Category());
		return "admin/category-form";
	}

	@PostMapping
	public String save(@ModelAttribute Category c) {
		categoryService.save(c);
		return "redirect:/admin/categories";
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model m) {
		m.addAttribute("category", categoryService.findById(id).orElseThrow());
		return "admin/category-form";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		categoryService.deleteById(id);
		return "redirect:/admin/categories";
	}
}
