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

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Employer {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    private int id;

    @Email(message = "Invalid email") //company e-mail
    @NotBlank(message = "E-mail is required")
    private String email;

    @NotBlank(message = "Employer name field empty") //@NotBlank -> not null or whitespace
    @Size(min = 20, max = 50)
    private String name;

    @NotBlank(message = "Location required")
    @Size(min = 20, max = 50)
    private String location;

    @NotBlank(message = "Industry required")
    @Size(min = 20, max = 50)
    private String industry;

    @Pattern(regexp = "\\d{10}", message = "Phone Number must be 10 digits") // number is stored as string and then validated
    @PositiveOrZero(message = "Only positive numbers are accepted for contact number") // accepts 0 or greater only
    private int phoneNumber;

}
