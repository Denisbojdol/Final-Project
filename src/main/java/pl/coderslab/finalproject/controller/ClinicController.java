package pl.coderslab.finalproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClinicController {

    @GetMapping("/")
    public String main() {
        return "index";
    }


    @GetMapping("/home")
    public String home() {
        return "ClinicMain";
    }


}
