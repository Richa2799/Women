package com.app.model;

import javax.persistence.*;


@Entity
@Table(name="hostel")
public class Hostel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	String Location;
	int Vacancy;
	Long mobileNumber;	
	String owner;	
	int capacity;

	public Hostel() {
		super();
	}

	public Hostel(Long id, String name, String location, int vacancy, Long mobileNumber, String owner, int capacity) {
		super();
		this.id = id;
		this.name = name;
		Location = location;
		Vacancy = vacancy;
		this.mobileNumber = mobileNumber;
		this.owner = owner;
		this.capacity = capacity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getVacancy() {
		return Vacancy;
	}

	public void setVacancy(int vacancy) {
		Vacancy = vacancy;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
