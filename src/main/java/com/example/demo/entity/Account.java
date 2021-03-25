package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_id;

	private String userName;
	private String passWord;

//	@Override
//	public String toString() {
//		return "Account [id=" + account_id + ", username= " + userName + ", password= " + passWord + "]";
//	}
}
