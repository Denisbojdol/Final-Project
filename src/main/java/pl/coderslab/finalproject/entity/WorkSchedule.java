package pl.coderslab.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "workSchedule")
@Getter
@Setter
public class WorkSchedule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime begin;

    @NotNull
    private LocalDateTime end;

    @NotNull
    private String day;

    @ManyToOne
    private Doctor doctor;

}
