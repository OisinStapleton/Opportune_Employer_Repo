package ie.atu.opportune_employer.service;

import ie.atu.opportune_employer.exception.EmployerNotFoundException;
import ie.atu.opportune_employer.model.Employer;
import ie.atu.opportune_employer.repository.EmployerRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerRepo employerRepo;

    public EmployerService(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }


    //Create
    public Employer create(Employer employer) {
        employerRepo.save(employer);
        return employer;
    }

    //Get all
    public List<Employer> getAll(){
        return employerRepo.findAll();
    }

    //Get by ID
    public Employer getById(Integer id){
        return employerRepo.findById(id).orElseThrow(() -> new EmployerNotFoundException("Employer ID not found"));
    }

    //Get by Name
    public List<Employer> getByName(String name) {
        return employerRepo.findByName(name);
    }

}
