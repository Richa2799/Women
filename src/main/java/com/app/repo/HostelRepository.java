package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.model.Hostel;

@Repository
public interface HostelRepository extends JpaRepository<Hostel,Long> {
	
}
