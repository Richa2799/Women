package com.app.model;

import javax.persistence.*;
//comment
@Entity
@Table(name="candidateschemes")
public class CandidateSchemes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	Schemes schemes;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "id")
	Candidate candidate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Schemes getSchemes() {
		return schemes;
	}

	public void setSchemes(Schemes schemes) {
		this.schemes = schemes;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	
	

}