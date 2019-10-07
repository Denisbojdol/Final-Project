package pl.coderslab.finalproject.entity;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.securityEntity.User;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "physiotherapist")
@Getter
@Setter
public class Physiotherapist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Email
    private String email;

    @OneToOne
    private User user;


}
