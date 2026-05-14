package ie.atu.opportune_employer.controller;


import ie.atu.opportune_employer.model.Employer;
import ie.atu.opportune_employer.service.EmployerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    //Creation
    @PostMapping
    public ResponseEntity<Employer> create(@Valid @RequestBody Employer employer){
        Employer saved = employerService.create(employer);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all employers
    @GetMapping
    public ResponseEntity<List<Employer>> getAll(){
        return ResponseEntity.ok(employerService.getAll());
    }

    // Get one employer
    @GetMapping("/employers/{id}")
    public ResponseEntity<Employer> getById(@PathVariable Integer id){
        return ResponseEntity.ok(employerService.getById(id));
    }

    //Get one by name
    @GetMapping ("/name/{name}")
    public ResponseEntity<List<Employer>> getByEmployerName(@PathVariable String name){
        return ResponseEntity.ok(employerService.getByName(name));
    }
}
