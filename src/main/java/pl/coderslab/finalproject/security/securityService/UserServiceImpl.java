package pl.coderslab.finalproject.security.securityService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.coderslab.finalproject.exception.ObjectError;
import pl.coderslab.finalproject.exception.ValidationException;
import pl.coderslab.finalproject.security.securityDTO.UserDTO;
import pl.coderslab.finalproject.security.securityRepository.RoleRepository;
import pl.coderslab.finalproject.security.securityRepository.UserRepository;
import pl.coderslab.finalproject.security.securityEntity.Role;
import pl.coderslab.finalproject.security.securityEntity.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder, Validator validator) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.validator = validator;
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public User authorization(UserDTO userDTO) throws ValidationException{
        Set<ConstraintViolation<UserDTO>> errors = validator.validate(userDTO);
        ValidationException ex = new ValidationException();

        if(!errors.isEmpty()){
            for(ConstraintViolation<UserDTO> err : errors){
                ex.addError( new ObjectError(err.getPropertyPath().toString(), err.getMessage()));
            }
            throw ex;
        }

        User user = new User();
        User existing = findByUserName(userDTO.getUsername());
        if (existing != null) {
            ex.addError( new ObjectError("username","There is already an account registered with that email"));
        }
        if (!userDTO.getPassword().equals(userDTO.getPassword2())) {
            ex.addError( new ObjectError("password","Passwords are incorrect"));

        }

        if (ex.hasErrors()) {
            throw ex;
        }

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        //todo :: save
        userRepository.save(user);

        return user;
    }



    @Override
    public void register(UserDTO userDTO, BindingResult result) {
        try {
            User user = authorization(userDTO);
            saveUser(user);

        } catch (ValidationException e) {

            List<ObjectError> errors = e.getErrors();
            for (ObjectError err : errors) {
                if (result.getFieldError(err.getFieldName()) == null) {
                    result.rejectValue(err.getFieldName(), null, err.getMessage());
                }
            }
        }
    }

    @Override
    public void saveDoctor(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setEnabled(1);
            Role userRole = roleRepository.findByName("ROLE_DOCTOR");
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userRepository.save(user);
        }
}
