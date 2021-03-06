package pl.coderslab.finalproject.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Table(name = "office")
@Getter
@Setter
@Entity
@ToString
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean open;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime begin;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime end;

    private String day;

}
