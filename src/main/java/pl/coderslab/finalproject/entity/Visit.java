package pl.coderslab.finalproject.entity;


import ch.qos.logback.core.net.server.Client;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "visit")
@Getter
@Setter
@ToString
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitData;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime visitTime;

    private boolean smsInformation;

    private boolean confirm;

    @OneToOne
    private Doctor doctor;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Treatment treatment;






}
