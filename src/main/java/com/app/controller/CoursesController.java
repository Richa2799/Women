package com.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.ResourceNotFoundException;
import com.app.model.Courses;
import com.app.service.CoursesService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class CoursesController {
	
	 @Autowired
		private CoursesService coursesService;
	    
	 @GetMapping("/courses")
	    public List<Courses> getAllCourses() {
	        return coursesService.Courseslist();
	    }

	    @GetMapping("/courses/{id}")
	    public ResponseEntity<Courses> getCoursesById(@PathVariable(value = "id") Long CoursesId)
	        throws ResourceNotFoundException {
	    	Courses courses = coursesService.findById(CoursesId)
	          .orElseThrow(() -> new ResourceNotFoundException("courses not found for this id :: " + CoursesId));
	        return ResponseEntity.ok().body(courses);
	    }
	    
	    @PostMapping("/courses")
	    public Courses createCourses(@Valid @RequestBody Courses courses) {
	        return coursesService.save(courses);
	    }

	    @PutMapping("/courses/{id}")
	    public ResponseEntity<Courses> updateCourses(@PathVariable(value = "id") Long coursesId,
	         @Valid @RequestBody Courses coursesDetails) throws ResourceNotFoundException {
	    	Courses courses= coursesService.findById(coursesId)
	        .orElseThrow(() -> new ResourceNotFoundException("courses not found for this id :: " +coursesId));
	        
	    	    courses.setName(coursesDetails.getName());
                courses.setId(coursesDetails.getId());
                courses.setDuration(coursesDetails.getDuration());
                courses.setTrainingsector(coursesDetails.getTrainingsector());
                courses.setCriteria(coursesDetails.getCriteria());
                courses.setLanguage(coursesDetails.getLanguage());
                
	    	
			final Courses updateCourses = coursesService.save(courses);
	        return ResponseEntity.ok(updateCourses);
	    }

	    @DeleteMapping("/courses/{id}")
	    public Map<String, Boolean> deleteCourses(@PathVariable(value = "id") Long coursesId)
	         throws ResourceNotFoundException {
	    	Courses courses = coursesService.findById(coursesId)
	       .orElseThrow(() -> new ResourceNotFoundException("courses not found for this id :: " + coursesId));

	    	coursesService.delete(courses);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
}