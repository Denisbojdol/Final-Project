package pl.coderslab.finalproject.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.exceptions.ObjectError;
import pl.coderslab.finalproject.exceptions.ValidationException;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.UserData;
import pl.coderslab.finalproject.securityEntity.securityService.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    private String register(Model model) {
        model.addAttribute("user", new UserData());
        return "register";
    }


    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserData userData, BindingResult result) {


        try {
            User user = userService.authorization(userData);
            userService.saveUser(user);
        } catch (ValidationException e) {

            List<ObjectError> errors = e.getErrors();
            for (ObjectError err : errors) {
                if (result.getFieldError(err.getFieldName()) == null) {
                    result.rejectValue(err.getFieldName(), null, err.getMessage());
                }
            }

        }
        if (result.hasErrors()) {
            return "register";
        }
        return "redirect:login";
    }


}
