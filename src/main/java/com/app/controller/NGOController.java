package com.app.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;
import com.app.model.Admin;
import com.app.model.NGO;
import com.app.service.NGOService;

@RestController
public class NGOController {
	
	 @Autowired
		private NGOService ngoService;
	    
	 @GetMapping("/ngo")
	    public List<NGO> getAllNGO() {
	        return ngoService.findAll();
	    }

	    @GetMapping("/ngo/{nid}")
	    public ResponseEntity<NGO> getNGOById(@PathVariable(value = "nid") Long ngoNid)
	        throws ResourceNotFoundException {
	    	NGO ngo = ngoService.findById(ngoNid)
	          .orElseThrow(() -> new ResourceNotFoundException("ngo not found for this id :: " + ngoNid));
	        return ResponseEntity.ok().body(ngo);
	    }
	    
	    @GetMapping("/getNGOByEmail/{email}")
	    public Optional<NGO> getNGOByEmail(@PathVariable(value = "email") String email)
	        throws ResourceNotFoundException {
	    	Optional<NGO> n = ngoService.getByEmail(email);
	        return n;
	    }
	    
	    @GetMapping("/ngoByEmail/{email}")
	    public boolean getAdminByEmail(@PathVariable(value = "email") String email)
	        throws ResourceNotFoundException {
	    	boolean n = ngoService.findByEmail(email);
	        return n;
	    }
	    @CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/ngo")
	    public NGO createNGO(@Valid @RequestBody NGO ngo) {
	        return ngoService.save(ngo);
	    }

	    @PutMapping("/ngo/{nid}")
	    public ResponseEntity<NGO> updateNGO(@PathVariable(value = "nid") Long ngoNid,
	         @Valid @RequestBody NGO ngoDetails) throws ResourceNotFoundException {
	    	NGO ngo = ngoService.findById(ngoNid)
	        .orElseThrow(() -> new ResourceNotFoundException("ngo not found for this id :: " +ngoNid));
	        
	    	ngo.setName(ngoDetails.getName());
	    	ngo.setStepStatus(ngoDetails.getStepStatus());
	    	ngo.setEmail(ngoDetails.getEmail());
	    	ngo.setPassword(ngoDetails.getPassword());
	    	ngo.setCountry(ngoDetails.getCountry());
	    	ngo.setState(ngoDetails.getState());
	    	ngo.setCity(ngoDetails.getCity());
	    	ngo.setAddressLine(ngoDetails.getAddressLine());
	    	ngo.setDirector(ngoDetails.getDirector());
	    	ngo.setType(ngoDetails.getType());
	    	
	        final NGO updateNGO = ngoService.save(ngo);
	        return ResponseEntity.ok(updateNGO);
	    }

	    @DeleteMapping("/ngo/{nid}")
	    public Map<String, Boolean> deleteNGO(@PathVariable(value = "nid") Long ngoNid)
	         throws ResourceNotFoundException {
	    	NGO ngo = ngoService.findById(ngoNid)
	       .orElseThrow(() -> new ResourceNotFoundException("ngo not found for this id :: " + ngoNid));

	    	ngoService.delete(ngo);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
}
