package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.entity.PatientCard;
import pl.coderslab.finalproject.entity.Visit;
import pl.coderslab.finalproject.entity.WorkSchedule;
import pl.coderslab.finalproject.repository.*;

import java.time.LocalDateTime;

public class PhysiotherapistService implements PhysiotherapistInterface {

    private PatientCardRepository patientCardRepository;
    private ClientRepository clientRepository;
    private VisitRepository visitRepository;
    private WorkScheduleRepository workScheduleRepository;
    private PhysiotherapistRepository physiotherapistRepository;

    @Override
    public void visitAuthorization(boolean accept,Long id) {
        Visit visit = visitRepository.getOne(id);
        visit.setConfirmation(accept);
    }

    @Override
    public void setWorkingTime(LocalDateTime begin, LocalDateTime end, String day,Long id) {
        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setBegin(begin);
        workSchedule.setEnd(end);
        workSchedule.setDay(day);
        workSchedule.setPhysiotherapist(physiotherapistRepository.getOne(id));
        workScheduleRepository.save(workSchedule);

    }


    @Override
    public void setTreatmentMethods() {



    }

    @Override
    public void writeRecommendationToClient(LocalDateTime data,Long id,String description) {
        PatientCard patientCard = new PatientCard();
        patientCard.setTreatmentData(data);
        patientCard.setClient(clientRepository.getOne(id));
        patientCard.setTreatmentDescription(description);
        patientCardRepository.save(patientCard);
    }
}
