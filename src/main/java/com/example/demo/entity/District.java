//package com.example.demo.entity;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.Data;
//
//@Data
//@Entity
//public class District {//huyen/quan
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id_district;
//	private String name;
//	private String Code;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "province_id")
//	private Province province; 
//	
//	@OneToMany(mappedBy = "ward_id", cascade = CascadeType.ALL, orphanRemoval = true)
//	@JsonIgnore
//	private List<Ward> wards; 
//}
