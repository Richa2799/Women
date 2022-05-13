package com.app.service;

import java.util.List;

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
	
	public List<NGO> ngolist()
	{
		return nr.findAll();
	}
}