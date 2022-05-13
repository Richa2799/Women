package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Hostel;
import com.app.repo.HostelRepository;

@Service
@Transactional
public class HostelService {
@Autowired
HostelRepository hr;

public List<Hostel>HostelList(){
	return hr.findAll();
}
}
