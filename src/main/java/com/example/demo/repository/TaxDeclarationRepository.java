package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TaxDeclaration;

public interface TaxDeclarationRepository extends JpaRepository<TaxDeclaration, Long>{
	public TaxDeclaration findByUserId(Integer id);
}
