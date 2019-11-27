package com.cos.crud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.crud.model.User;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "<h1>This is index page</h1>";
		} else {
			return "<h1>This is user page</h1>";
		}
	}

}
