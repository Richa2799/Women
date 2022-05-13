package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.CandidateSchemes;
import com.app.service.CandidateSchemesService;


@RestController
public class CandidateSchemesController {
	@Autowired
	CandidateSchemesService css;
	
	@GetMapping("/getAllCandidateSchemes")	
	public List<CandidateSchemes> getCandidateSchemesList(){
		return css.CandidateSchemesList();
	}
}