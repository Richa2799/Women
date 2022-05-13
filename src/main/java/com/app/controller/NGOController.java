package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import com.app.model.NGO;
import com.app.service.NGOService;

public class NGOController {
	
	 @Autowired
		NGOService ns;
	    
	    @GetMapping("/ngo")
	    public List<NGO> ngolist() {
	        return ns.ngolist();
	    }

}
