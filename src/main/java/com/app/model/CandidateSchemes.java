package com.app.model;

import javax.persistence.*;

@Entity
@Table(name="candidateschemes")
public class CandidateSchemes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String status;
	
	@ManyToOne	
	Schemes schemes;
	
	@ManyToOne
	Candidate candidate;

	public CandidateSchemes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidateSchemes(Long id, String status, Schemes schemes, Candidate candidate) {
		super();
		this.id = id;
		this.status = status;
		this.schemes = schemes;
		this.candidate = candidate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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