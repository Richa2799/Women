package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;

import com.app.model.Hostel;
import com.app.service.HostelService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HostelController {
	@Autowired
	HostelService hs;

	@GetMapping("/Hostel")
	public List<Hostel> getHostelList() {
		return hs.HostelList();
	}

	@GetMapping("/Hostel/{id}")
	public ResponseEntity<Hostel> getHostelById(@PathVariable(value = "id") Long hostelId)
			throws ResourceNotFoundException {
		Hostel hostel = hs.findById(hostelId)
				.orElseThrow(() -> new ResourceNotFoundException("candidate not found for this id :: " + hostelId));
		return ResponseEntity.ok().body(hostel);
	}

	@PostMapping("/Hostel")
	public Hostel createHostel( @RequestBody Hostel hostel) {
		return hs.save(hostel);
	}

	@PutMapping("/Hostel/{id}")
	public ResponseEntity<Hostel> updateHostel(@PathVariable(value = "id") Long hostelId,
			 @RequestBody Hostel hostelDetails) throws ResourceNotFoundException {
		Hostel hostel = hs.findById(hostelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hostel not found for this id :: " + hostelId));

		hostel.setId(hostelDetails.getId());
		hostel.setName(hostelDetails.getName());
		hostel.setMobileNumber(hostelDetails.getMobileNumber());
		hostel.setOwner(hostelDetails.getOwner());
		hostel.setLocation(hostelDetails.getLocation());
		hostel.setCapacity(hostelDetails.getCapacity());
		hostel.setVacancy(hostelDetails.getVacancy());

		final Hostel updateHostel = hs.save(hostel);
		return ResponseEntity.ok(updateHostel);
	}

	@DeleteMapping("/Hostel/{id}")
	public Map<String, Boolean> deleteHostel(@PathVariable(value = "id") Long hostelId)
			throws ResourceNotFoundException {
		Hostel hostel = hs.findById(hostelId)
				.orElseThrow(() -> new ResourceNotFoundException("hostel not found for this id :: " + hostelId));
			hs.delete(hostel);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
	}

}
