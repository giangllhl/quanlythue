package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.User;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

	List<BankAccount> findByUserId(Integer id);

}
