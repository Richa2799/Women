package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.model.Candidate;
import com.app.repo.CandidateRepository;

@Service
@Transactional
public class CandidateService {

	@Autowired
	CandidateRepository cr;
	
	public List<Candidate> findAll(){
		return cr.findAll();
	}
	
	public Optional<Candidate> findById(Long candidateId){
		return cr.findById(candidateId);
	}
	
	public Optional<Candidate> getByEmail(String email){
		return Optional.of(cr.findByEmail(email));
	}
	
	public boolean findByEmail(String email){
		try {
			Optional<Candidate> candidate = Optional.of(cr.findAll().stream()
				    .filter(user -> user.getEmail().equalsIgnoreCase(email) || user.getEmail().equalsIgnoreCase(email))
				    .findFirst().get());
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public Candidate save(Candidate candidate){
		return cr.save(candidate);
	}
	
	public void delete(Candidate candidate) {
		cr.delete(candidate);
	}
}
