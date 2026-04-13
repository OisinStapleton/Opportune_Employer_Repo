package ie.atu.opportune_employer.repository;

import ie.atu.opportune_employer.model.Employer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployerRepo extends JpaRepository<Employer,String> {

    List<Employer> findByEmployerName(String EmployerName);
   Optional<Employer> findByEmployerId(long EmployerId); //Returns null if no existing employer
}
