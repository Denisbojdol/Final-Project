package pl.coderslab.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.data.AdminData;
import pl.coderslab.finalproject.entity.Admin;
import pl.coderslab.finalproject.repository.AdminRepository;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class AdminController {

    private AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping("/pannel")
    private String adminPage(Model model) {
        model.addAttribute("adminData", new AdminData());
        return "adminPannel";
    }

    @PostMapping("/pannel")
    private String adminData(@ModelAttribute("adminData") @Valid AdminData adminData,BindingResult result) {

        if (result.hasErrors()) {
            return "adminPannel";
        }
        Admin admin = new Admin();
        admin.setEmail(adminData.getEmail());
        admin.setName(adminData.getName());
        admin.setSurname(adminData.getSurname());
        adminRepository.save(admin);

        return "edit";
    }


}
