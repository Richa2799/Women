package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.model.CandidateSchemes;
import com.app.repo.CandidateSchemesRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CandidateSchemesService {

	@Autowired
	CandidateSchemesRepository pr;
	
	public List<CandidateSchemes> CandidateSchemesList(){
		return pr.findAll();
	}
	
	public Optional<CandidateSchemes> findById(Long adminId){

		return pr.findById(adminId);
	}
	
	public CandidateSchemes save(CandidateSchemes admin){
		return pr.save(admin);
	}
	
	public void delete(CandidateSchemes admin) {
		pr.delete(admin);
	}
}