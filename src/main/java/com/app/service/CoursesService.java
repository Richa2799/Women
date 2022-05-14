package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Courses;
import com.app.model.Hostel;
import com.app.repo.CoursesRepository;

@Service
@Transactional
public class CoursesService {
	@Autowired
    CoursesRepository cr;
	
	public List<Courses> Courseslist()
	{
		return cr.findAll();
	}
	public Optional<Courses> findById(Long coursesId){
		return cr.findById(coursesId);
	}

	public Courses save(Courses courses) {
		return cr.save(courses);
	}
	public void delete(Courses courses) {
		cr.delete(courses);
	}
}