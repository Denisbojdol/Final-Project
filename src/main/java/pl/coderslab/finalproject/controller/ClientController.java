package pl.coderslab.finalproject.controller;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.finalproject.data.AdminData;
import pl.coderslab.finalproject.data.ClientData;
import pl.coderslab.finalproject.data.VisitData;
import pl.coderslab.finalproject.entity.*;
import pl.coderslab.finalproject.repository.*;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.CurrentUser;
import pl.coderslab.finalproject.securityEntity.securityService.UserData;
import pl.coderslab.finalproject.securityEntity.securityService.UserRepository;
import pl.coderslab.finalproject.securityEntity.securityService.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class ClientController {

    private OfficeRepository officeRepository;
    private UserRepository userRepository;
    private ClientRepository clientRepository;
    private PhysiotherapistRepository physiotherapistRepository;
    private VisitRepository visitRepository;
    private TreatmentRepository treatmentRepository;

    public ClientController(VisitRepository visitRepository, PhysiotherapistRepository physiotherapistRepository,
                            ClientRepository clientRepository, OfficeRepository officeRepository,
                            UserRepository userRepository, TreatmentRepository treatmentRepository) {
        this.officeRepository = officeRepository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.physiotherapistRepository = physiotherapistRepository;
        this.visitRepository = visitRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @GetMapping("/edit")
    private String clientData(Model model) {
        model.addAttribute("clientData", new ClientData());
        return "clientEdit";
    }

    @PostMapping("/edit")
    private String clientData(@ModelAttribute("clientData") @Valid ClientData clientData,
                              BindingResult result,
                              @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            return "clientEdit";
        }
        User user = userRepository.findByUsername(currentUser.getUser().getUsername());
        Client client = new Client();
        if (clientRepository.findClientByUserId(user.getId()) != null) {
            client = clientRepository.findClientByUserId(user.getId());
        }

        client.setName(clientData.getName());
        client.setSurname(clientData.getSurname());
        client.setEmail(clientData.getEmail());
        client.setUser(user);

        clientRepository.save(client);

        return "client";

    }


    @GetMapping("/panel")
    private String edit(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        List<Office> plan = officeRepository.findAllBy();
        model.addAttribute("user", user);
        model.addAttribute("plan", plan);
        return "client";
    }

    @GetMapping("/selectvisit/{id}")
    private String visit(Model model) {
        List<Physiotherapist> list = physiotherapistRepository.findAllBy();
        List<Treatment> list2 = treatmentRepository.findAllBy();
        model.addAttribute("visitData", new VisitData());
        model.addAttribute("physiotherapist", list);
        model.addAttribute("treatment",list2);

        return "clientVisit";
    }

    @PostMapping("/selectvisit/{id}")
    private String visit(@ModelAttribute("visitData") @Valid VisitData visitData,
                         BindingResult result1,
                         @ModelAttribute("physiotherapist") @Valid Physiotherapist physiotherapist,
                         BindingResult result2,
                         @ModelAttribute("treatment") @Valid Treatment treatment,
                         BindingResult result3,
                         @AuthenticationPrincipal CurrentUser currentUser) {
        if (result1.hasErrors() || result2.hasErrors() || result3.hasErrors()) {
            return "clientVisit";
        }
        Visit visit = new Visit();
        Client client = clientRepository.findClientByUserId(currentUser.getUser().getId());
        visit.setVisitData(visitData.getVisitData());
        visit.setPhysiotherapist(visitData.getPhysiotherapist());
        visit.setTreatment(visitData.getTreatment());
        visit.setClient(client);

        visitRepository.save(visit);

        return "clientVisit";
    }
}




