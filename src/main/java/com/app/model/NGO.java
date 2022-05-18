package com.app.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ngo")
public class NGO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int nid;
	String name;
	@Column(unique=true)
	String email;
	String password;
	String country;
	String state;
	String city;
	String addressLine;
	String director;
	String type;
	String StepStatus;
	public String getStepStatus() {
		return StepStatus;
	}
	public void setStepStatus(String stepStatus) {
		StepStatus = stepStatus;
	}
	public NGO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NGO(int nid, String name, String email, String password, String country, String state, String city,
			String addressLine, String director, String type, String stepStatus) {
		super();
		this.nid = nid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
		this.state = state;
		this.city = city;
		this.addressLine = addressLine;
		this.director = director;
		this.type = type;
		StepStatus = stepStatus;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
