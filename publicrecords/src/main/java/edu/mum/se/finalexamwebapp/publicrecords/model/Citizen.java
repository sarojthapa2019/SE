package edu.mum.se.finalexamwebapp.publicrecords.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citizenId;

    @NotNull(message = "* Social Security Number is required")
    @Digits(integer = 9, fraction = 0, message = "* ssn must be numeric")
    @Column( nullable = false, unique = true)
    @NumberFormat(pattern = "xxx-xx-xxxx")
    private Long socialSecurityNumber;

    @NotBlank(message = "* firstName is required ")
    private String firstName;

    private String middleName;

    @NotBlank(message = "* lastName is required ")
    private String lastName;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "* Dob is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "* yearlyIncome is required")
    @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric format")
    @NumberFormat(pattern = "#,###.##", style = NumberFormat.Style.CURRENCY)
    private double yearlyIncome;

    @ManyToOne()
    @JoinColumn(name = "stateId", nullable = false)
    private State state;

}
