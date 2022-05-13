package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.CandidateSchemes;
import com.app.repo.CandidateSchemesRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CandidateSchemesService {

	@Autowired
	CandidateSchemesRepository pr;
	
	public List<CandidateSchemes>CandidateSchemesList(){
		return pr.findAll();
	}
}