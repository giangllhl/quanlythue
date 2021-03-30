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
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Controller
@RequestMapping("/")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepo;

	@GetMapping
	public String loginForm(Model model) {
		model.addAttribute("account", new Account());
		model.addAttribute("message", "");
		return "login";
	}

	@PostMapping("/login")
	public String login(Account acc, Model model) {
		List<Account> list = accountRepo.findByUserNameAndPassWord(acc.getUserName(), acc.getPassWord());
		System.out.println(acc);
		System.out.println(list);
		if (list.size() != 0) {
			model.addAttribute("message", "Login success");
			return "success"; 
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
