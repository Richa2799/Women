package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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
import com.app.model.Schemes;
import com.app.service.SchemesService;


//Schemes Controller
@RestController
public class SchemesController {
	@Autowired
	SchemesService ss;
	
	@GetMapping("/schemes")
    public List<Schemes> getAllschemes() {
        return ss.SchemesList();
    }

    @GetMapping("/schemes/{id}")
    public ResponseEntity<Optional<Schemes>> getschemeById(@PathVariable(value = "id") Long schemeId)
        throws ResourceNotFoundException {
    	Optional<Schemes> scheme = ss.findById(schemeId);
        return ResponseEntity.ok().body(scheme);
    }
    
    @PostMapping("/schemes")
    public Schemes createscheme(@Valid @RequestBody Schemes scheme) {
        return ss.save(scheme);
    }

    @PutMapping("/schemes/{id}")
    public ResponseEntity<Schemes> updatescheme(@PathVariable(value = "id") Long schemesId,@Valid @RequestBody Schemes schemeDetails) throws ResourceNotFoundException {
    	Schemes scheme = ss.findById(schemesId)
        .orElseThrow(() -> new ResourceNotFoundException("scheme not found for this id :: " + schemesId));

        
    	scheme.setId(schemeDetails.getId());
    	scheme.setName(schemeDetails.getName());
    	scheme.setCriteria(schemeDetails.getCriteria());
    	scheme.setBenefits(schemeDetails.getBenefits());
        final Schemes updatescheme = ss.save(scheme);
        return ResponseEntity.ok(updatescheme);
    }

    @DeleteMapping("/schemes/{id}")
    public Map<String, Boolean> deletescheme(@PathVariable(value = "id") Long schemeId)
         throws ResourceNotFoundException {
    	Schemes scheme = ss.findById(schemeId)
       .orElseThrow(() -> new ResourceNotFoundException("scheme not found for this id :: " + schemeId));

    	ss.delete(scheme);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}