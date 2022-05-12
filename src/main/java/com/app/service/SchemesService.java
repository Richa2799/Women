package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.app.model.Schemes;
import com.app.repo.SchemesRepository;

@Service
@Transactional
public class SchemesService {

	@Autowired
	SchemesRepository pr;
	
	public List<Schemes>SchemesList(){
		return pr.findAll();
	}
}