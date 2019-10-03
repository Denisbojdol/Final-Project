package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.finalproject.security.securityDTO.UserDTO;
import pl.coderslab.finalproject.security.securityService.UserService;
import pl.coderslab.finalproject.service.PatientService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final PatientService patientService;

    public RegistrationController(UserService userService, PatientService patientService) {
        this.userService = userService;
        this.patientService = patientService;
    }


    @GetMapping("/register")
    private String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }


    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result) {
        userService.register(userDTO, result);
        if (result.hasErrors()) {
            return "register";
        }
        patientService.createPatient(userDTO);
        return "redirect:login";

    }
    }
