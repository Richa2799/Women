package com.app.model;

import javax.persistence.*;

@Entity
@Table(name="schemes")
public class Schemes{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String criteria;
	String benefits;
	
	public Schemes(int id, String name, String criteria, String benefits) {
		super();
		this.id = id;
		this.name = name;
		this.criteria = criteria;
		this.benefits = benefits;
	}
	public Schemes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	

}