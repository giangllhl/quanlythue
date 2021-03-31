package com.example.demo.controller;

import java.util.Arrays;
import java.util.*;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public String loginForm(Model model) {
		model.addAttribute("account", new Account());
		model.addAttribute("message", "");
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "username") String userName,@RequestParam(name = "password") String passWord, Model model) {
		Account a = accountRepo.findByUsernameAndPassword(userName,passWord);
//		System.out.println(userName+"   "+passWord);
//		System.out.println(a);
		User u = userRepo.findByAccountId(a.getId());
		if (a != null) {
			model.addAttribute("user", u);
			return "home"; 
		} else {
			model.addAttribute("message", "Wrong username or password");
			return "login";
		}
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("account", new Account());
		model.addAttribute("message", "");
		return "register";
	}
	
	@PostMapping("/register")
	public String register (Account acc, Model model) {
		accountRepo.save(acc);
		model.addAttribute("message", "Register success");
		return "success";
	}
}
