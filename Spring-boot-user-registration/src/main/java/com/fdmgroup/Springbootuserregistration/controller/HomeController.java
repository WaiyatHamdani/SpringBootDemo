package com.fdmgroup.Springbootuserregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping
	public String toHome(Model model, @RequestParam(name="username")String username) {
		model.addAttribute("username",username);
		return "home";
	}
}
