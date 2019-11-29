package com.cos.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.crud.model.User;
import com.cos.crud.repository.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	private UserRepository mRepo;
	
	//유저리스트
	@GetMapping("/admin/list")
	public String adminList(Model model) {
		List<User> users = mRepo.findAll();
		model.addAttribute("users",users);
		return "/admin/list";
	}
	
	//상세보기
	@GetMapping("/admin/user/{id}")
	public String adminUser(@PathVariable int id, Model model) {
		Optional<User> user = mRepo.findById(id);
		model.addAttribute("user", user.get());
		return "admin/user";
	}
	
	@GetMapping("/admin/update")
	public String admin() {
		return "admin/user";
	}
	
	@PostMapping("/admin/update")
	public String adminUpdate(User user) {
		//admin update 로직 필요
		mRepo.save(user);
		
		return "redirect:/admin";
	}
}
