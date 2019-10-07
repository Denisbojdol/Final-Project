package pl.coderslab.finalproject.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.finalproject.securityEntity.User;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
public class PhysiotherapistData {

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
