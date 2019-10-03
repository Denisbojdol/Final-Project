package pl.coderslab.finalproject.security.securityDTO;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @Email
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String password2;
    @Size(min = 2, max = 40)
    private String name;
    @Size(min = 2, max = 40)
    private String surname;
}
