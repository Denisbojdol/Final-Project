package pl.coderslab.finalproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.data.PatientDTO;
import pl.coderslab.finalproject.data.VisitDTO;
import pl.coderslab.finalproject.entity.Patient;
import pl.coderslab.finalproject.entity.Visit;
import pl.coderslab.finalproject.repository.DoctorRepository;
import pl.coderslab.finalproject.repository.OfficeRepository;
import pl.coderslab.finalproject.repository.PatientRepository;
import pl.coderslab.finalproject.repository.VisitRepository;
import pl.coderslab.finalproject.security.securityEntity.User;
import pl.coderslab.finalproject.security.securityRepository.UserRepository;
import pl.coderslab.finalproject.security.securityService.CurrentUser;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class PatientController {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final OfficeRepository officeRepository;
    private final DoctorRepository doctorRepository;
    private final VisitRepository visitRepository;

    public PatientController(DoctorRepository doctorRepository, PatientRepository patientRepository, UserRepository userRepository, OfficeRepository officeRepository, VisitRepository visitRepository) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.officeRepository = officeRepository;
        this.doctorRepository = doctorRepository;
        this.visitRepository = visitRepository;
    }

    @GetMapping("/edit")
    private String clientData(Model model) {
        model.addAttribute("patientDTO", new PatientDTO());
        return "patientEdit";
    }

    @PostMapping("/edit")
    private String clientData(@ModelAttribute("patientDTO") @Valid PatientDTO patientDTO,
                              BindingResult result,
                              @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "patientEdit";
        }
        User user = userRepository.findByUsername(currentUser.getUser().getUsername());
        Patient patient = new Patient();
        if (patientRepository.findPatientByUserId(user.getId()) != null) {
            patient = patientRepository.findPatientByUserId(user.getId());
        }

        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setEmail(patientDTO.getEmail());
        patient.setUser(user);

        patientRepository.save(patient);

        return "redirect:/admin/patientEdit";

    }

    @GetMapping("/panel")
    private String visit(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();

        model.addAttribute("user", user);
        model.addAttribute("plan", officeRepository.findAll());
        model.addAttribute("visitDTO", new VisitDTO());
        model.addAttribute("doctors",doctorRepository.findAll());
        return "patient";
    }

    @PostMapping("/panel")
    private String edit(@ModelAttribute("visitDTO") @Valid VisitDTO visitDTO,
                        BindingResult result,
                     @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "patient";
        }
        Visit visit = new Visit();
        Patient patient = patientRepository.findPatientByUserId(currentUser.getUser().getId());
        visit.setVisitData(visitDTO.getVisitData());
        visit.setVisitTime(visitDTO.getVisitTime());
        visit.setPatient(patient);
        visit.setDoctor(visitDTO.getDoctor());
        visitRepository.save(visit);

        return "redirect:panel";
    }
}
