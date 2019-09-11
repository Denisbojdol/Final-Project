package pl.coderslab.finalproject.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit")
@Getter
@Setter
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime visitData;

    @NotNull
    private boolean smsInformation;

    private boolean confirmation;

    @OneToOne
    private Physiotherapist physiotherapist;

    @OneToOne
    private Client client;

    @OneToOne
    private Treatment treatment;






}
