package edu.mum.se.finalexamwebapp.publicrecords.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;

    @NotBlank(message = "* 3 character State Code is required")
    @Size(min = 3, max = 3)
    private String stateCode;

    @NotBlank(message = "* stateName is required")
    private String stateName;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<Citizen> citizenList = new ArrayList<>();
}
