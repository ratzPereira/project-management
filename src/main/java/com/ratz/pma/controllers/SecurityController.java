package com.ratz.pma.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ratz.pma.entities.UserAccount;
import com.ratz.pma.services.UserService;

@Controller
public class SecurityController {

	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String registrer(Model model) {
		
	
		UserAccount userAccount = new UserAccount();
		
		model.addAttribute("userAccount", userAccount);
		
		return "security/register";
	}
	
	@PostMapping("/register/save")
	public String saveUser(Model model, UserAccount user) {
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		
		userService.save(user);
		
		return "redirect:/";
	}
}
