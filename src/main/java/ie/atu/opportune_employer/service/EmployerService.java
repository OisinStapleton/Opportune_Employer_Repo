package ie.atu.opportune_employer.service;

import ie.atu.opportune_employer.exception.EmployerNotFoundException;
import ie.atu.opportune_employer.model.Employer;
import ie.atu.opportune_employer.repository.EmployerRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    private List<Employer> employers;
    private final EmployerRepo employerRepository;

    public EmployerService(EmployerRepo employerRepository) {
        this.employerRepository = employerRepository;
    }


    //Create
    public Employer addEmployer(Employer employer) {
        employers = employerRepository.findAll();

        employerRepository.save(employer);
        return employer;
    }

    //Get all
    public List<Employer> getAllEmployers(){
        return employerRepository.findAll();
    }

    //Get by ID
    public Employer getEmployerId(String EmployerId){
        return employerRepository.findById(EmployerId).orElseThrow(() -> new EmployerNotFoundException("Employer ID not found"));
    }

    //Get by Name
    public @Nullable List<Employer> getByEmployerName(String Employername) {
        return employerRepository.findByName(Employername);
    }

}
