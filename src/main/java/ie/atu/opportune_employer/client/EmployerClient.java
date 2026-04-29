package ie.atu.opportune_employer.client;

import ie.atu.opportune_employer.model.Employer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="employer-service", url = "http://localhost:8082")
public interface EmployerClient {
    @GetMapping("/employer")
    Employer getEmployer(@PathVariable long id);
}
