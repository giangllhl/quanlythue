	package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullName;
	private String cmt;
	private String gender;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    private String homeTown;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;
	
//	@OneToMany(mappedBy = "bankAccount_id", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnore
//	private List<BankAccount> bankAccounts; 
	
}
