package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.UserData;
import pl.coderslab.finalproject.securityEntity.securityService.UserService;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/edit")
    private String edit() {
        return "edit";
    }


}