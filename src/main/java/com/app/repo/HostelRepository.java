package com.app.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Hostel;

public interface HostelRepository extends JpaRepository<Hostel,Integer> {
	
}
