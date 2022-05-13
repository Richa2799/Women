package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Admin;
import com.app.repo.AdminRepository;


@Service
@Transactional
public class AdminService {
	@Autowired
	AdminRepository ar;
	
	public List<Admin> findAllAdmins(){
		return ar.findAll();
	}
	
<<<<<<< HEAD
	public Optional<Admin> findById(Long adminId){
=======
	public Optional<Admin> findById(int adminId){
>>>>>>> branch 'main' of https://github.com/prmane03/WomenEmpowerment
		return ar.findById(adminId);
	}
	
	public Admin save(Admin admin){
		return ar.save(admin);
	}
	
	public void delete(Admin admin) {
		ar.delete(admin);
	}
}
