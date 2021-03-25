//package com.example.demo.api;
//
//import java.util.ArrayList;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.repository.AccountRepository;
//import com.example.demo.entity.Account;
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping(path = "/account", produces = "application/json")
//public class AccountAPI {
//
//	
//	private AccountRepository accountRepo;
//	
//	@GetMapping
//	public List<Account> getAll(){
//		List<Account> list = new ArrayList<>();
//		list = accountRepo.findAll();
//		return list;
//	}
//	
//	@PostMapping
//	public Account addAccount(@RequestBody Account account) {
//		return accountRepo.save(account);
//	}
//	
//	@PutMapping
//	public Account updateAccount(@RequestBody Account account) {
//		accountRepo.save(account);
//		return account;
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteAccount(@PathVariable("id") String id ) {
//		accountRepo.deleteById(Long.parseLong(id));
//	}
//}
