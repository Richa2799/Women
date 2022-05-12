package Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Admin;
import model.Candidate;
import repo.CandidateRepository;

@Service
@Transactional
public class CandidateService {

	@Autowired
	CandidateRepository cr;
	
//	public List<Candidate> findAll(){
//		return cr.findAll();
//	}
//	
//	public Optional<Candidate> findById(Long candidateId){
//		return cr.findById(candidateId);
//	}
//	
//	public Candidate save(Candidate candidate){
//		return cr.save(candidate);
//	}
//	
//	public void delete(Candidate candidate) {
//		cr.delete(candidate);
//	}
}
