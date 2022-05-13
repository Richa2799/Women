package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;
import com.app.model.CandidateSchemes;
import com.app.service.CandidateSchemesService;


@RestController
public class CandidateSchemesController {

	 @Autowired
	 private CandidateSchemesService canidateschemesService;

	    @GetMapping("/candidateschemes")
	    public List<CandidateSchemes> getAllCandidateSchemes() {
	        return CandidateSchemesService.findAllCandidateSchemes();
	    }

	    @GetMapping("/candidateschemes/{id}")
	    public ResponseEntity<Optional<CandidateSchemes>> getCandidateSchemesById(@PathVariable(value = "id") Long candidateschemesId)
	        throws ResourceNotFoundException {
	    	Optional<CandidateSchemes> candidateschemes = candidateschemesService.findById(candidateschemesId);
	        return ResponseEntity.ok().body(candidateschemes);
	    }
	    
	    @PostMapping("/candidateschemes")
	    public CandidateSchemes createCandidateSchemes(@Valid @RequestBody CandidateSchemes candidateschemes) {
	        return candidateschemesService.save(candidateschemes);
	    }

	    @PutMapping("/candidateschemes/{id}")
	    public ResponseEntity<CandidateSchemes> updateCandidateSchemes(@PathVariable(value = "id") Long candidateschemesId,@Valid @RequestBody CandidateSchemes candidateschemesDetails) throws ResourceNotFoundException {
	    	CandidateSchemes candidateschemes = candidateschemesService.findById(candidateschemesId)
	        .orElseThrow(() -> new ResourceNotFoundException("CandidateSchemes not found for this id :: " + candidateschemesId));

	        
	    	candidateschemes.setId(candidateschemesDetails.getId());
	    	candidateschemes.setStatus(candidateschemesDetails.getStatus());
	    	candidateschemes.setEmail(candidateschemesDetails.getEmail());
	    	candidateschemes.setPassword(candidateschemesDetails.getPassword());
	        final CandidateSchemes updateAdmin = candidateschemesService.save(candidateschemes);
	        return ResponseEntity.ok(updateAdmin);
	    }

	    @DeleteMapping("/candidateschemes/{id}")
	    public Map<String, Boolean> deleteCandidatesSchemes(@PathVariable(value = "id") Long candidateschemesId)
	         throws ResourceNotFoundException {
	    	CandidateSchemes admin =candidateschemesService.findById(candidateschemesId)
	       .orElseThrow(() -> new ResourceNotFoundException("CandidateSchemes not found for this id :: " + candidateschemesId));

	    	CandidateSchemesService.delete(candidateschemes);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	}