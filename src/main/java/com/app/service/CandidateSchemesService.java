package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Candidate;
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
	public Optional<CandidateSchemes> findById(Long candidateSchemeId){
		return pr.findById(candidateSchemeId);
	}
	
	public CandidateSchemes save(CandidateSchemes candidateScheme){
		return pr.save(candidateScheme);
	}
	
	public void delete(CandidateSchemes candidateSchemes) {
		pr.delete(candidateSchemes);
	}
}