package com.fdmgroup.Springbootuserregistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.Springbootuserregistration.model.User;
import com.fdmgroup.Springbootuserregistration.repository.UserRepository;

@Controller
@RequestMapping("/login")
// for every method in class annotated with @RequestMapping, @getMapping, etc
//prepend /login to it's uri path
public class LoginController {
	
	private ApplicationContext context;
	
	
	@Autowired
	public LoginController(ApplicationContext context) {
		super();
		this.context = context;
	}



	@PostMapping
	public  String login(Model model,User user) {
		UserRepository repository= context.getBean(UserRepository.class);
//		repository.save(user);
		
		Optional<User> optionalUser = repository.findByUsername(user.getUsername());
		
		if(optionalUser.isPresent()) {
			User foundUser = optionalUser.get();
			
			//check if the password  of founduser and user match
			
		}else {
			model.addAttribute("error","not found");
		}
		return "index";
	}
	
}
