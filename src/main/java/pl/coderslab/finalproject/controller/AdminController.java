package pl.coderslab.finalproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.finalproject.data.AdminDTO;
import pl.coderslab.finalproject.data.DoctorDTO;
import pl.coderslab.finalproject.data.OfficeDTO;
import pl.coderslab.finalproject.entity.Doctor;
import pl.coderslab.finalproject.entity.Office;
import pl.coderslab.finalproject.repository.AdminRepository;
import pl.coderslab.finalproject.repository.DoctorRepository;
import pl.coderslab.finalproject.repository.OfficeRepository;
import pl.coderslab.finalproject.security.securityEntity.User;
import pl.coderslab.finalproject.security.securityService.CurrentUser;
import pl.coderslab.finalproject.service.AdminService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final DoctorRepository doctorRepository;
    private final AdminService adminService;
    private final AdminRepository adminRepository;
    private final OfficeRepository officeRepository;

    public AdminController(DoctorRepository doctorRepository, AdminService adminService, AdminRepository adminRepository, OfficeRepository officeRepository) {
        this.doctorRepository = doctorRepository;
        this.adminService = adminService;
        this.adminRepository = adminRepository;
        this.officeRepository = officeRepository;
    }


    @GetMapping("/main")
    public String admin(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("admin", user);
        return "adminMain";
    }


    @GetMapping("/doctor")
    public ModelAndView doctorForm() {
        return new ModelAndView("addDoctor", Map.of(
                "doctorDTO", new DoctorDTO(),
                "doctorList",doctorRepository.findAll()
        ));
    }

    @PostMapping("/doctor")
    public String doctorForm(@ModelAttribute("doctorDTO") @Valid DoctorDTO doctorDTO, BindingResult result) {
        if (result.hasErrors()) {
            return  "addDoctor";
        }
        adminService.createDoctor(doctorDTO);
        return "redirect:/admin/doctor";
    }

    @GetMapping("/edit")
    private String adminData(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        if (adminRepository.findAdminByUserId(currentUser.getUser().getId()) != null) {
            model.addAttribute("admin", adminRepository.findAdminByUserId(currentUser.getUser().getId()));
        }
        model.addAttribute("adminDTO", new AdminDTO());
        return "editAdmin";
    }

    @PostMapping("/edit")
    private String adminDataSave(@ModelAttribute("adminDTO") @Valid AdminDTO adminDTO,
                                 BindingResult result,
                                 @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "editAdmin";
        }
        adminService.changeAdminData(adminDTO, currentUser);
        return "redirect:/admin/edit";
    }

    @GetMapping("/doctorDelete/{id}")
    private String deleteDoctor(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getOne(id);
        doctorRepository.delete(doctor);
        return "redirect:/admin/doctor";
    }
    @GetMapping("/workTime")
    private String setWorkingTime(Model model) {
        model.addAttribute("officeDTO", new OfficeDTO());
        model.addAttribute("plan", officeRepository.findAll());
        return "setTime";
    }

    @PostMapping("/workTime")
    private String setWorkingTime(@ModelAttribute("officeDTO") @Valid OfficeDTO officeDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "setTime";
        }
        System.out.println(officeDTO.getBegin());
        System.out.println(officeDTO.getEnd());
        System.out.println(officeDTO.getDay());
        System.out.println(officeDTO.isOpen());
        adminService.selectOfficeWorkingTime(officeDTO);
        return "redirect:/admin/workTime";

    }
    @ModelAttribute("days")
    public Collection<String> days() {
        List<String> days = new ArrayList<String>();
        days.add("Poniedzialek");
        days.add("Wtorek");
        days.add("Sroda");
        days.add("Czwartek");
        days.add("Piatek");
        days.add("Sobota");
        days.add("Niedziela");
        return days;
    }





}
