package ie.atu.opportune_employer.exception;

public class EmployerNotFoundException extends RuntimeException {

    public EmployerNotFoundException(String employerNotFound)
    {
        super(employerNotFound);
    }
}
