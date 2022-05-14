package com.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Courses")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
    public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courses(int id, int duration, String name, String trainingsector, String criteria, String language, NGO n) {
		super();
		this.id = id;
		this.duration = duration;
		this.name = name;
		this.trainingsector = trainingsector;
		this.criteria = criteria;
		this.language = language;
		this.n = n;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrainingsector() {
		return trainingsector;
	}
	public void setTrainingsector(String trainingsector) {
		this.trainingsector = trainingsector;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public NGO getN() {
		return n;
	}
	public void setN(NGO n) {
		this.n = n;
	}
	int duration;
	String name;
	String trainingsector;
	String criteria;
	String language;
	@ManyToOne
    NGO n;
}