package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.CandidateCourse;

public interface CandidateCourseRepository extends JpaRepository<CandidateCourse,Long>{

}
