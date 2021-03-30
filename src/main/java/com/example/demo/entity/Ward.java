package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Ward {//Xa/phuong
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ward_id;
	private String name;
	private String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id")
	private District district; 
}
