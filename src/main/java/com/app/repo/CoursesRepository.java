package com.app.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Courses;


	@Repository
	public interface CoursesRepository extends JpaRepository<Courses,Long>{

		}

