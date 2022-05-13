package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.app.model.NGO;
import com.app.service.NGOService;

@RestController
@RequestMapping("N")
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

