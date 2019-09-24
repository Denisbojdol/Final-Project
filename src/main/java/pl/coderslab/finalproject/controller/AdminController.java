package pl.coderslab.finalproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.data.AdminData;
import pl.coderslab.finalproject.data.OfficeData;
import pl.coderslab.finalproject.data.PhysiotherapistData;
import pl.coderslab.finalproject.entity.*;
import pl.coderslab.finalproject.repository.AdminRepository;
import pl.coderslab.finalproject.repository.OfficeRepository;
import pl.coderslab.finalproject.repository.PhysiotherapistRepository;
import pl.coderslab.finalproject.repository.VisitRepository;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.CurrentUser;
import pl.coderslab.finalproject.securityEntity.securityService.UserRepository;
import pl.coderslab.finalproject.service.AdminService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
//@Secured("ROLE_ADMIN")
public class AdminController {

    private AdminRepository adminRepository;
    private PhysiotherapistRepository physiotherapistRepository;
    private AdminService adminService;
    private OfficeRepository officeRepository;
    private VisitRepository visitRepository;

    @Autowired
    public AdminController(OfficeRepository officeRepository, AdminService adminService, AdminRepository adminRepository,
                           PhysiotherapistRepository physiotherapistRepository, VisitRepository visitRepository) {
        this.adminRepository = adminRepository;
        this.physiotherapistRepository = physiotherapistRepository;
        this.adminService = adminService;
        this.officeRepository = officeRepository;
        this.visitRepository = visitRepository;
    }

    @GetMapping("/page")
    public String admin(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("admin", user);
        return "adminPage";
    }

    @GetMapping("/edit")
    private String adminData(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        if (adminRepository.findAdminByUserId(currentUser.getUser().getId()) != null) {
            model.addAttribute("admin", adminRepository.findAdminByUserId(currentUser.getUser().getId()));
        }
        model.addAttribute("adminData", new AdminData());
        return "adminEdit";
    }

    @PostMapping("/edit")
    private String adminDataSave(@ModelAttribute("adminData") @Valid AdminData adminData,
                                 BindingResult result,
                                 @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "adminEdit";
        }
        adminService.changeAdminData(adminData, currentUser);

        return "adminPage";
    }


    @GetMapping("/addPhy")
    private String addPhysiotherapist(Model model) {
        model.addAttribute("physiotherapistData", new PhysiotherapistData());
        model.addAttribute("phylist", physiotherapistRepository.findAll());
        return "adminAddPhy";
    }

    @PostMapping("/addPhy")
    private String addPhysiotherapist(@ModelAttribute("physiotherapistData") @Valid
                                              PhysiotherapistData physiotherapistData, BindingResult result) {
        if (result.hasErrors()) {
            return "adminAddPhy";
        }
        adminService.createPhysiotherapist(physiotherapistData);
        return "adminPage";
    }

    @GetMapping("/workTime")
    private String setWorkingTime(Model model) {
        List<Office> plan = officeRepository.findAllBy();

        model.addAttribute("officeData", new OfficeData());
        model.addAttribute("plan", plan);

        return "adminSetTime";
    }

    @PostMapping("/workTime")
    private String setWorkingTime(@ModelAttribute("officeData") @Valid OfficeData officeData, BindingResult result) {
        if (result.hasErrors()) {
            return "adminSetTime";
        }

        adminService.selectOfficeWorkingTime(
                officeData.getBegin(), officeData.getEnd(), officeData.isOpen()
        );
        return "redirect:/admin/workTime";

    }

    @GetMapping("/workTime/{id}")
    private String editTime(@PathVariable Long id, Model model) {
        model.addAttribute("time", new OfficeData());
        return "EditTime";
    }

    @PostMapping("/workTime/{id}")
    private String editTime(@ModelAttribute("time") @Valid OfficeData officeData, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "EditTime";
        }
        adminService.editOfficeWorkingTime(officeData,id);
        return "redirect:/admin/workTime";
    }

    @GetMapping("/workTimeDelete/{id}")
    private String delete(@PathVariable Long id) {
        Office office = officeRepository.getOne(id);
        officeRepository.delete(office);
        return "redirect:/admin/workTime";
    }

    @GetMapping("/work")
    private String work(Model model) {
        List<Visit> list = visitRepository.findAll();
        model.addAttribute("Visits", list);
        return "work";
    }


}
