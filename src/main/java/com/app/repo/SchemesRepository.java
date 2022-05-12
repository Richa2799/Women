package com.app.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Schemes;

public interface SchemesRepository extends JpaRepository<Schemes,Integer>{

//	public List<Product> findAll();
	
}