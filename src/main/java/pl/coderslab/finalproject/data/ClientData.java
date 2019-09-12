package pl.coderslab.finalproject.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.finalproject.entity.PatientCard;
import pl.coderslab.finalproject.securityEntity.User;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
public class ClientData {


    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String email;

    @OneToOne
    private PatientCard patientCard;

    @OneToOne
    private User user;
}
