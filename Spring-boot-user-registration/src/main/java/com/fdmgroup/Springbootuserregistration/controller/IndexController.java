package com.fdmgroup.Springbootuserregistration.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.Springbootuserregistration.model.User;

@Controller
public class IndexController {
	
	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String toIndex(Model model,@Autowired User user) {
		model.addAttribute("cookies","i like cookies");
		model.addAttribute("user",context.getBean(User.class));
		List<User> users = new ArrayList<>(Arrays.asList(new User("billy","billyRock"),new User("Bobby","bobbyRocks")));
		model.addAttribute("users",users);
		return "index";
	}
	
	

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	//short hand for @RequestMapping(value="/search",method=RequestMethod.GET)
//	@GetMapping("/search")
//	public String search(HttpServletRequest request, HttpServletResponse resp) {
//		String input = request.getParameter("searchTerm");
//		return "redirect:https://www.google.com/search?q="+input;
//	}
	
	
	//short hand for @RequestMapping(value="/search",method=RequestMethod.GET)
//	@GetMapping("/search")
//	public String search(@RequestParam String searchTerm) {
//		return "redirect:https://www.google.com/search?q="+searchTerm;
//	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value="searchTerm") String input) {
		return "redirect:https://www.google.com/search?q="+input;
	}
}
