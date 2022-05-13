package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;
import com.app.model.Candidate;
import com.app.model.Hostel;
import com.app.service.HostelService;

@RestController
public class HostelController {
	@Autowired
	HostelService hs;
	
	
	@GetMapping("/Hostel")
	public List<Hostel> getHostelList(){
		return hs.HostelList();
	}
}
