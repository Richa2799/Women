package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.app.model.Admin;
import com.app.model.Schemes;
import com.app.repo.SchemesRepository;

@Service
@Transactional
public class SchemesService {

	@Autowired
	SchemesRepository pr;
	
	public List<Schemes> SchemesList(){
		return pr.findAll();
	}
	
	public Optional<Schemes> findById(Long schemeId){
		return pr.findById(schemeId);
	}
	
	public Schemes save(Schemes scheme){
		return pr.save(scheme);
	}
	
	public void delete(Schemes scheme) {
		pr.delete(scheme);
	}
}