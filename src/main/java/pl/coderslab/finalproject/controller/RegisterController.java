package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.data.ClientData;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.exceptions.ObjectError;
import pl.coderslab.finalproject.exceptions.ValidationException;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.UserData;
import pl.coderslab.finalproject.securityEntity.securityService.UserService;
import pl.coderslab.finalproject.service.ClientService;

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
        model.addAttribute("client", new ClientData());
        return "register";
    }


    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserData userData, BindingResult result) {

        userService.register(userData, result);
        if (result.hasErrors()) {
            return "register";
        }
        return "redirect:login";
    }


}
