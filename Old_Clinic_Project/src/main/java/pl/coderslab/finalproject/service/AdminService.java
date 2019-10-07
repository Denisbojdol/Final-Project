package pl.coderslab.finalproject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.data.AdminData;
import pl.coderslab.finalproject.data.OfficeData;
import pl.coderslab.finalproject.data.PhysiotherapistData;
import pl.coderslab.finalproject.entity.*;
import pl.coderslab.finalproject.repository.*;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AdminService implements AdminInterface {

    private OfficeRepository officeRepository;
    private PhysiotherapistRepository physiotherapistRepository;
    private ClientRepository clientRepository;
    private TreatmentRepository treatmentRepository;
    private UserServiceImpl userService;
    private UserRepository userRepository;
    private AdminRepository adminRepository;

    public AdminService(UserRepository userRepository, UserServiceImpl userService, OfficeRepository officeRepository,
                        PhysiotherapistRepository physiotherapistRepository, ClientRepository clientRepository,
                        TreatmentRepository treatmentRepository, UserRepository userRepository1, AdminRepository adminRepository) {
        this.officeRepository = officeRepository;
        this.physiotherapistRepository = physiotherapistRepository;
        this.clientRepository = clientRepository;
        this.treatmentRepository = treatmentRepository;
        this.userService = userService;
        this.userRepository = userRepository1;
        this.adminRepository = adminRepository;
    }

    @Override
    public void changeAdminData(AdminData adminData, CurrentUser currentUser) {
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
    }

    @Override
    public void selectOfficeWorkingTime(LocalDateTime begin, LocalDateTime end, boolean open) {
        Office office = new Office();
        office.setBegin(begin);
        office.setEnd(end); // dodaj przedzial godzinowy i warunek ze begin > end;
        office.setOpen(open); // ustaw domyślnie 0 jako zamknięte w encji
        officeRepository.save(office);
    }

    @Override
    public void editOfficeWorkingTime(OfficeData officeData, Long id) {
        Office office = officeRepository.getOne(id);
        office.setEnd(officeData.getEnd());
        office.setBegin(officeData.getBegin());
        office.setOpen(officeData.isOpen());
        officeRepository.save(office);
    }

    @Override
    public void createPhysiotherapist(PhysiotherapistData physiotherapistData) { //addp
        Physiotherapist physiotherapist = new Physiotherapist();
        User user = new User();
        physiotherapist.setName(physiotherapistData.getName());
        physiotherapist.setSurname(physiotherapistData.getSurname());
        physiotherapist.setEmail(physiotherapistData.getEmail());
        user.setPassword(physiotherapist.getName());
        user.setUsername(physiotherapist.getEmail());
        physiotherapist.setUser(user);
        userService.savePhysiotherapist(user);


        physiotherapistRepository.save(physiotherapist);
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
    public void setTreatmentPrice(BigDecimal bigDecimal, String name) {
        treatmentRepository.findByName(name).setPrice(bigDecimal);

    }
}
