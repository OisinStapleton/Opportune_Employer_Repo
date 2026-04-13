package ie.atu.opportune_employer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static jakarta.persistence.GenerationType.IDENTITY;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    /*EmployerID will only set in this database, JobPosting database should be able to take the employer info and reuse it*/
    private Long EmployerId; // company ID automatically assigned (easy for openfeign to find ID in table).

    private Long userId; // Need to put into jobpost

    @Email(message = "E-mail required") //company e-mail
    private String EmployerEmail;

    @NotBlank(message = "Employer name field empty") //@NotBlank -> not null or whitespace
    private String EmployerName;

    @NotNull(message = "Location field must be filled") //@NotNull -> just not null
    private String EmployerLocation;

    @NotNull(message = "Industry field must be filled")
    private String EmployerIndustry;

    @Min(value = 10) // sets minimum value of 10 digits for phone number
    @PositiveOrZero(message = "Only positive numbers are accepted for contact number") // accepts 0 or greater only
    private int EmployerPhoneNumber;

}
