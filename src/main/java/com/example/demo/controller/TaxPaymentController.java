package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.entity.Account;
import com.example.demo.entity.BankAccount;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/payment")
public class TaxPaymentController {
	
	@Autowired
	private BankAccountRepository bankAccountRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/{id}")
	public String chooseBank (@PathVariable("id") Integer id , Model model) {
		Optional<User> u = userRepo.findById(id);
		System.out.println("dcm user day"+u);
		List<BankAccount> listbanks =  bankAccountRepo.findByUserId(id);
//		bankAccountRepo.findByUserId(id_user)
		System.out.println(listbanks);
		model.addAttribute("banks",listbanks);
		return "choosebank";
	}
}
