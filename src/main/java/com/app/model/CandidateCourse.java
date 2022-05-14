package com.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="CandidateCourse")
public class CandidateCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public CandidateCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateCourse(int id, int completiondate, String status, String trainingsector, Candidate c, Courses s) {
		super();
		this.id = id;
		this.completiondate = completiondate;
		this.status = status;
		this.trainingsector = trainingsector;
		this.c = c;
		this.s = s;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompletiondate() {
		return completiondate;
	}
	public void setCompletiondate(int completiondate) {
		this.completiondate = completiondate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrainingsector() {
		return trainingsector;
	}
	public void setTrainingsector(String trainingsector) {
		this.trainingsector = trainingsector;
	}
	public Candidate getC() {
		return c;
	}
	public void setC(Candidate c) {
		this.c = c;
	}
	public Courses getS() {
		return s;
	}
	public void setS(Courses s) {
		this.s = s;
	}
	int completiondate;
	String status;
	String trainingsector;
	@ManyToOne
	Candidate c;
	@ManyToOne
	Courses s;

	
}