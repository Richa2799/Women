package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.model.NGO;
import com.app.repo.NGORepository;

@Service
@Transactional
public class NGOService {
	@Autowired
    NGORepository nr;
	
	public List<NGO> findAll()
	{
		return nr.findAll();
	}
	
	public Optional<NGO> findById(Long ngoNid){
		return nr.findById(ngoNid);
	}
	
	public NGO save(NGO ngo){
		return nr.save(ngo);
	}
	
	public void delete(NGO ngo) {
		nr.delete(ngo);
	}

	
}
