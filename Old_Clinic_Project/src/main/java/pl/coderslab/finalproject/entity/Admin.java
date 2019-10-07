package pl.coderslab.finalproject.entity;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.securityEntity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String email;

    @OneToOne
    private User user;





}
