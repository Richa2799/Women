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
import com.app.model.CandidateCourse;
import com.app.repo.CandidateCourseRepository;
import com.app.service.CandidateCourseService;

@RestController
public class CandidateCourseController {

	 @Autowired
	    private CandidateCourseService candidatecourseService;

	    @GetMapping("/candidatecourses")
	    public List<CandidateCourse> getAllCandidatecourses() {
	        return candidatecourseService.CandidateCourselist();
	    }

	    @GetMapping("/candidatecourses/{id}")
	    public ResponseEntity<CandidateCourse> getCandidatecourseById(@PathVariable(value = "id") Long candidatecourseId)
	        throws ResourceNotFoundException {
	    	CandidateCourse candidatecourse = candidatecourseService.findById(candidatecourseId)
	          .orElseThrow(() -> new ResourceNotFoundException("candidatecourse not found for this id :: " + candidatecourseId));
	        return ResponseEntity.ok().body(candidatecourse);
	    }
	    
	    @PostMapping("/candidatecourses")
	    public CandidateCourse createCandidatecourse(@Valid @RequestBody CandidateCourse candidatecourse) {
	        return candidatecourseService.save(candidatecourse);
	    }

	    @PutMapping("/candidatecourses/{id}")
	    public ResponseEntity<CandidateCourse> updateCandidatecourse(@PathVariable(value = "id") Long candidatecourseId,
	         @Valid @RequestBody CandidateCourse candidatecourseDetails) throws ResourceNotFoundException {
	    	CandidateCourse candidatecourse = candidatecourseService.findById(candidatecourseId)
	        .orElseThrow(() -> new ResourceNotFoundException("candidatecourse not found for this id :: " +candidatecourseId));
	        
	    	candidatecourse.setId(candidatecourseDetails.getId());
	    	candidatecourse.setCompletiondate(candidatecourseDetails.getCompletiondate());
	    	candidatecourse.setStatus(candidatecourseDetails.getStatus());
	    	candidatecourse.setTrainingsector(candidatecourseDetails.getTrainingsector());
	    	
	    	
	        final CandidateCourse updateCandidatecourse = candidatecourseService.save(candidatecourse);
	        return ResponseEntity.ok(updateCandidatecourse);
	    }

	    @DeleteMapping("/candidatecourses/{id}")
	    public Map<String, Boolean> deleteCandidatecourse(@PathVariable(value = "id") Long candidatecourseId)
	         throws ResourceNotFoundException {
	    	CandidateCourse candidatecourse = candidatecourseService.findById(candidatecourseId)
	       .orElseThrow(() -> new ResourceNotFoundException("candidatecourse not found for this id :: " + candidatecourseId));

	    	candidatecourseService.delete(candidatecourse);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
}
