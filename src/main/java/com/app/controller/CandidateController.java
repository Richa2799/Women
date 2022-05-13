package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;
import com.app.model.Candidate;
import com.app.repo.CandidateRepository;
import com.app.service.CandidateService;

@RestController
@RequestMapping("A")
public class CandidateController {

	 @Autowired
	    private CandidateService candidateService;

	    @GetMapping("/candidates")
	    public List<Candidate> getAllCandidates() {
	        return candidateService.findAll();
	    }

	    @GetMapping("/candidates/{id}")
	    public ResponseEntity<Candidate> getCandidateById(@PathVariable(value = "id") Long candidateId)
	        throws ResourceNotFoundException {
	    	Candidate candidate = candidateService.findById(candidateId)
	          .orElseThrow(() -> new ResourceNotFoundException("candidate not found for this id :: " + candidateId));
	        return ResponseEntity.ok().body(candidate);
	    }
	    
	    @PostMapping("/candidates")
	    public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
	        return candidateService.save(candidate);
	    }

	    @PutMapping("/candidates/{id}")
	    public ResponseEntity<Candidate> updateCandidate(@PathVariable(value = "id") Long candidateId,
	         @Valid @RequestBody Candidate candidateDetails) throws ResourceNotFoundException {
	    	Candidate candidate = candidateService.findById(candidateId)
	        .orElseThrow(() -> new ResourceNotFoundException("candidate not found for this id :: " +candidateId));
	        
	    	candidate.setId(candidateDetails.getId());
	    	candidate.setFname(candidateDetails.getFname());
	    	candidate.setLname(candidateDetails.getLname());
	    	candidate.setEmail(candidateDetails.getEmail());
	    	candidate.setPassword(candidateDetails.getPassword());
	    	candidate.setNationality(candidateDetails.getNationality());
	    	candidate.setCountry(candidateDetails.getCountry());
	    	candidate.setState(candidateDetails.getState());
	    	candidate.setCity(candidateDetails.getCity());
	    	candidate.setAddressLine(candidateDetails.getAddressLine());
	    	candidate.setMotherName(candidateDetails.getMotherName());
	    	candidate.setFatherName(candidateDetails.getFatherName());
	    	candidate.setMobile(candidateDetails.getMobile());
	    	candidate.setAge(candidateDetails.getAge());
	    	candidate.setDob(candidateDetails.getDob());
	    	candidate.setAdharNumber(candidateDetails.getAdharNumber());
	    	candidate.setHighestQualification(candidateDetails.getHighestQualification());
	    	candidate.setMaritalStatus(candidateDetails.getMaritalStatus());
	    	candidate.setIncome(candidateDetails.getIncome());
	    	candidate.setWorking(candidateDetails.isWorking());
	    	candidate.setIncomeProof(candidateDetails.getIncomeProof());
	    	candidate.setAdharPhoto(candidateDetails.getAdharPhoto());
	    	candidate.setHighestQualificationProof(candidateDetails.getHighestQualificationProof());
	    	
	        final Candidate updateCandidate = candidateService.save(candidate);
	        return ResponseEntity.ok(updateCandidate);
	    }

	    @DeleteMapping("/candidates/{id}")
	    public Map<String, Boolean> deleteCandidate(@PathVariable(value = "id") Long candidateId)
	         throws ResourceNotFoundException {
	    	Candidate candidate = candidateService.findById(candidateId)
	       .orElseThrow(() -> new ResourceNotFoundException("candidate not found for this id :: " + candidateId));

	    	candidateService.delete(candidate);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
}
