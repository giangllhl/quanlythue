package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	public List<Account> findByUserNameAndPassWord(String userName, String passWord);
}
