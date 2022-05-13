package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.CandidateSchemes;

public interface CandidateSchemesRepository extends JpaRepository<CandidateSchemes,Long>{

}