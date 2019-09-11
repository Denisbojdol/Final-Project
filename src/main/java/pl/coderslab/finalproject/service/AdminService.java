package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.entity.*;
import pl.coderslab.finalproject.repository.ClientRepository;
import pl.coderslab.finalproject.repository.OfficeRepository;
import pl.coderslab.finalproject.repository.PhysiotherapistRepository;
import pl.coderslab.finalproject.repository.TreatmentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AdminService implements AdminInterface {

    private OfficeRepository officeRepository;
    private PhysiotherapistRepository physiotherapistRepository;
    private ClientRepository clientRepository;
    private TreatmentRepository treatmentRepository;

    @Override
    public void selectOfficeWorkingTime(LocalDateTime begin, LocalDateTime end,String day,boolean open) {
        Office office = new Office();
        office.setBegin(begin);
        office.setEnd(end); // dodaj przedzial godzinowy i warunek ze begin > end;
        office.setDay(day); // dodaj 6 dni tygodnia warunek jakis switch idk.
        office.setOpen(open); // ustaw domyślnie 0 jako zamknięte w encji
        officeRepository.save(office);
    }

    @Override
    public void createPhysiotherapist(Physiotherapist physiotherapist) { //addp

    }

    @Override
    public void setOfficeScheduleInformation(String information) {

    }

    @Override
    public void removePhysiotherapist(Physiotherapist physiotherapist) {
            physiotherapistRepository.delete(physiotherapist);
    }

    @Override
    public void removeClient(Client client) {
            clientRepository.delete(client);

    }

    @Override
    public void setTreatmentPrice(BigDecimal bigDecimal,String name) {
            treatmentRepository.findByName(name).setPrice(bigDecimal);

    }
}
