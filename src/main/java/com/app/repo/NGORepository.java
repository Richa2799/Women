package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.NGO;


@Repository

public interface NGORepository extends JpaRepository<NGO,Long>{

}