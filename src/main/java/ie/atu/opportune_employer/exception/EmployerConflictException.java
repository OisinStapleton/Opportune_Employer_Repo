package ie.atu.opportune_employer.exception;

public class EmployerConflictException extends RuntimeException {
    public EmployerConflictException(String employerduplicate) {
        super(employerduplicate);
    }
}
