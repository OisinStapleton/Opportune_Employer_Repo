package ie.atu.opportune_employer.repository;

import ie.atu.opportune_employer.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployerRepo extends JpaRepository<Employer,Integer> {
    List<Employer> findByName(String employerName);
}
