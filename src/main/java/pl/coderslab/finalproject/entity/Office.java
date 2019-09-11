package pl.coderslab.finalproject.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "office")
@Getter
@Setter
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean open;

    @NotNull
    private LocalDateTime begin;

    @NotNull
    private LocalDateTime end;

    @NotNull
    private String day;


}
