package pl.coderslab.finalproject.security.securityService;


import org.springframework.validation.BindingResult;
import pl.coderslab.finalproject.exception.ValidationException;
import pl.coderslab.finalproject.security.securityDTO.UserDTO;
import pl.coderslab.finalproject.security.securityEntity.User;

public interface UserService {

    User findByUserName(String username);

    void saveUser(User user);

    void register(UserDTO userDTO, BindingResult result);

    User authorization(UserDTO userDTO) throws ValidationException;

    void saveDoctor(User user);

}
