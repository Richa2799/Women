package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long>{

}
