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
    private int employerId; // company ID automatically assigned (easy for openfeign to find ID in table).

    @Email(message = "Invalid email") //company e-mail
    @NotBlank(message = "E-mail is required")
    private String employerEmail;

    @NotBlank(message = "Employer name field empty") //@NotBlank -> not null or whitespace
    private String employerName;

    @NotNull(message = "Location required") //@NotNull -> just not null
    private String employerLocation;

    @NotNull(message = "Industry required")
    private String employerIndustry;

    @Min(value = 10) // sets minimum value of 10 digits for phone number
    @Max(value = 10)
    @PositiveOrZero(message = "Only positive numbers are accepted for contact number") // accepts 0 or greater only
    private int employerPhoneNumber;


}
