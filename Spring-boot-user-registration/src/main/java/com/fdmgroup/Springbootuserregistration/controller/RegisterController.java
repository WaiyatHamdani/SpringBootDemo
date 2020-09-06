package com.fdmgroup.Springbootuserregistration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.Springbootuserregistration.model.User;

@Controller
@RequestMapping("/registering")
public class RegisterController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping  //--> this one for method get
//	@PostMapping   --> this one for method post
//	@RequestMapping --> this one for everything 
	public String registering(@RequestParam(value="username") String usern, @RequestParam(value="password") String pwd) {
		User u=context.getBean(User.class);
		u.setUsername(usern);
		u.setPassword(pwd);
		return "confirmation";
	}

}
