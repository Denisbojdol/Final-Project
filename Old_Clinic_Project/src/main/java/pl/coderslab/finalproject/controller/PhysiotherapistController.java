package pl.coderslab.finalproject.controller;


import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.entity.PatientCard;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.entity.Visit;
import pl.coderslab.finalproject.repository.PatientCardRepository;
import pl.coderslab.finalproject.repository.PhysiotherapistRepository;
import pl.coderslab.finalproject.repository.VisitRepository;
import pl.coderslab.finalproject.securityEntity.securityService.CurrentUser;


import java.util.List;

@Controller
@RequestMapping("/employee")
public class PhysiotherapistController {

    private VisitRepository visitRepository;
    private PhysiotherapistRepository physiotherapistRepository;
    private PatientCardRepository patientCardRepository;

    public PhysiotherapistController(PatientCardRepository patientCardRepository, VisitRepository visitRepository, PhysiotherapistRepository physiotherapistRepository) {
        this.visitRepository = visitRepository;
        this.physiotherapistRepository = physiotherapistRepository;
    }

    @GetMapping("/panel")
    private String page(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        Physiotherapist physiotherapist = physiotherapistRepository
                .findByUserId(currentUser.getUser().getId());
        List<Visit> list = visitRepository.findAllByPhysiotherapistId(physiotherapist.getId());
        model.addAttribute("employee", physiotherapist);
        model.addAttribute("visits", list);
        model.addAttribute("card", new PatientCard());

        return "employeePanel";
    }

    @PostMapping("/panel")
    private String page(@ModelAttribute("visits") Visit visits) {

        Visit visit = visitRepository.getOne(visits.getId());
        visit.setConfirm(visits.isConfirm());
        visitRepository.save(visits);

        return "redirect:/employee/panel";
    }


//    @PostMapping("/raport")
//    private String raport(@ModelAttribute("card") PatientCard card) {
//        PatientCard patientCard = new PatientCard();
//        patientCard.setTreatmentData(LocalDateTime.now());
//        patientCard.setTreatmentDescription("bylo spoko");
//        patientCard.setClient(card.getClient());
//        patientCardRepository.save(patientCard);
//
//        return "redirect:/employee/panel";
//    }


}
