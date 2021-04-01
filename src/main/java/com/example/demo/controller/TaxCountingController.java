package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.TaxDeclaration;
import com.example.demo.entity.User;
import com.example.demo.repository.TaxDeclarationRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/counting")
public class TaxCountingController {
	@Autowired
	private TaxDeclarationRepository taxDeclarationRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/{iduser}")
	public String taxCounting (@PathVariable("iduser") Integer id , Model model){
		Optional<User> u = userRepo.findById(id);//lấy user để gen thông tin
		User user = null;
		if (u.isPresent()) {
			user = u.get();
		}
		TaxDeclaration td = taxDeclarationRepo.findByUserId(id);// lấy thông tin thuế đã khai báo để tín thuế
		double thue = 0;
		double thuNhapTinhThue;
		thuNhapTinhThue = td.getTotalIncome() - td.getTaxCut();
		if(thuNhapTinhThue<=5000000) thue = (double)thuNhapTinhThue*5/100;
		if(thuNhapTinhThue>5000000&&thuNhapTinhThue<=10000000) thue = (double)thuNhapTinhThue*10/100-250000;
		if(thuNhapTinhThue>10000000&&thuNhapTinhThue<=18000000) thue = (double)thuNhapTinhThue*15/100-750000;
		if(thuNhapTinhThue>18000000&&thuNhapTinhThue<=32000000) thue = (double)thuNhapTinhThue*20/100-1650000;
		if(thuNhapTinhThue>32000000&&thuNhapTinhThue<=52000000) thue = (double)thuNhapTinhThue*25/100-3250000;
		if(thuNhapTinhThue>52000000&&thuNhapTinhThue<=80000000) thue = (double)thuNhapTinhThue*30/100-5850000;
		if(thuNhapTinhThue>80000000) thue = (double)thuNhapTinhThue*35/100-9850000;
		model.addAttribute("user", user);
		model.addAttribute("infotax",td);
		model.addAttribute("tax",thue);
		System.out.println(u);
		System.out.println(td);
		System.out.println(thue);
		return "counting";
	}
}
