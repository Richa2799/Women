package com.app.service;


	import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.CandidateCourse;
import com.app.model.Courses;
import com.app.repo.CandidateCourseRepository;

	

	@Service
	@Transactional
	public class CandidateCourseService {
		@Autowired
	    CandidateCourseRepository cr;
		
		public List<CandidateCourse> CandidateCourselist()
		{
			return cr.findAll();
		}
		public Optional<CandidateCourse> findById(Long candidateCourseId){
			return cr.findById(candidateCourseId);
		}

		public CandidateCourse save(CandidateCourse candidateCourse) {
			return cr.save(candidateCourse);
		}
		public void delete(CandidateCourse candidateCourse) {
			cr.delete(candidateCourse);
		}
	}

