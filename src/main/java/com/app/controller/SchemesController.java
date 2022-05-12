package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Schemes;
import com.app.service.SchemesService;


@RestController
public class SchemesController {
	@Autowired
	SchemesService ss;
	
	@GetMapping("/getAllSchemes")	
	public List<Schemes> getSchemesList(){
		return ss.SchemesList();
	}
}