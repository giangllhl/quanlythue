package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Province {//Tinh/thanhpho
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprovince;
	private String name;
	private String code;
	
}
