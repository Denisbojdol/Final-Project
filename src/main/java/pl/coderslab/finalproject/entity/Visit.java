package pl.coderslab.finalproject.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime visitData;

    private boolean smsInformation;


    @OneToOne
    private Physiotherapist physiotherapist;

    @OneToOne
    private Client client;

    @OneToOne
    private Treatment treatment;






}
