package pl.coderslab.finalproject.entity;

import ch.qos.logback.core.net.server.Client;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "patientCard")
@Getter
@Setter
public class PatientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String treatmentDescription;


    private LocalDateTime treatmentData;

    @OneToOne
    private Patient patient;



}