package pl.coderslab.finalproject.controller;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.finalproject.data.AdminData;
import pl.coderslab.finalproject.data.OfficeData;
import pl.coderslab.finalproject.data.PhysiotherapistData;
import pl.coderslab.finalproject.entity.Admin;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Office;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.repository.AdminRepository;
import pl.coderslab.finalproject.repository.OfficeRepository;
import pl.coderslab.finalproject.repository.PhysiotherapistRepository;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.CurrentUser;
import pl.coderslab.finalproject.securityEntity.securityService.RoleRepository;
import pl.coderslab.finalproject.securityEntity.securityService.UserRepository;
import pl.coderslab.finalproject.service.AdminService;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private PhysiotherapistRepository physiotherapistRepository;
    private AdminService adminService;
    private OfficeRepository officeRepository;
    @Autowired
    public AdminController(AdminService adminService, AdminRepository adminRepository, RoleRepository roleRepository, UserRepository userRepository, PhysiotherapistRepository physiotherapistRepository) {
        this.adminRepository = adminRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.physiotherapistRepository = physiotherapistRepository;
        this.adminService = adminService;
    }

    @GetMapping("/page")
    public String admin(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("admin",user);
        return "adminPage";
    }

    @GetMapping("/edit")
    private String adminData(Model model) {
        model.addAttribute("adminData",new AdminData());
        return "adminEdit";
    }

    @PostMapping("/edit")
    private String adminDataSave(@ModelAttribute("adminData") @Valid AdminData adminData,
                                 BindingResult result,
                                 @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "adminEdit";
        }
        User user = userRepository.findByUsername(currentUser.getUser().getUsername());
        Admin admin = new Admin();
        if (adminRepository.findAdminByUserId(user.getId()) != null) {
            admin = adminRepository.findAdminByUserId(user.getId());
        }
        admin.setEmail(adminData.getEmail());
        admin.setName(adminData.getName());
        admin.setSurname(adminData.getSurname());

        admin.setUser(user);

        adminRepository.save(admin);

        return "adminPage";
    }


    @GetMapping("/addPhy")
    private String addPhysiotherapist(Model model) {
       model.addAttribute("physiotherapistData",new PhysiotherapistData());
       return "adminAddPhy";
    }

    @PostMapping("/addPhy")
    private String addPhysiotherapist(@ModelAttribute("physiotherapistData") @Valid
                                                  PhysiotherapistData physiotherapistData, BindingResult result) {
        if (result.hasErrors()) {
            return "adminAddPhy";
        }
        Physiotherapist physiotherapist = new Physiotherapist();
        physiotherapist.setName(physiotherapistData.getName());
        physiotherapist.setSurname(physiotherapistData.getSurname());
        physiotherapist.setEmail(physiotherapistData.getEmail());
        physiotherapistRepository.save(physiotherapist);
           return "adminPage";
    }

    @GetMapping("/workTime")
    private String setWorkingTime(Model model) {
        model.addAttribute("officeData",new OfficeData());
        return "adminSetTime";
    }

    @PostMapping("/workTime")
    private String setWorkingTime(@ModelAttribute("officeData") @Valid OfficeData officeData, BindingResult result) {
        if (result.hasErrors()) {
            return "adminSetTime";
        }

        adminService.selectOfficeWorkingTime(
                officeData.getBegin(),officeData.getEnd(),officeData.isOpen()
        );
        return "adminPage";


    }




//    @PostMapping("/workTime")
//    private String setWorkingTime(@ModelAttribute("physiotherapistData") @Valid
//                                              PhysiotherapistData physiotherapistData, BindingResult result)





}
