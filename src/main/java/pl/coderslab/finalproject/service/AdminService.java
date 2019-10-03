package pl.coderslab.finalproject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.data.AdminDTO;
import pl.coderslab.finalproject.data.DoctorDTO;
import pl.coderslab.finalproject.data.OfficeDTO;
import pl.coderslab.finalproject.entity.Admin;
import pl.coderslab.finalproject.entity.Doctor;
import pl.coderslab.finalproject.entity.Office;
import pl.coderslab.finalproject.entity.Patient;
import pl.coderslab.finalproject.repository.AdminRepository;
import pl.coderslab.finalproject.repository.DoctorRepository;
import pl.coderslab.finalproject.repository.OfficeRepository;
import pl.coderslab.finalproject.repository.PatientRepository;
import pl.coderslab.finalproject.security.securityEntity.User;
import pl.coderslab.finalproject.security.securityRepository.UserRepository;
import pl.coderslab.finalproject.security.securityService.CurrentUser;
import pl.coderslab.finalproject.security.securityService.UserService;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Service
public class AdminService implements AdminInterface {

    private final OfficeRepository officeRepository;
    private final UserService userService;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public AdminService(OfficeRepository officeRepository, UserService userService, DoctorRepository doctorRepository, PatientRepository patientRepository, UserRepository userRepository, AdminRepository adminRepository) {
        this.officeRepository = officeRepository;
        this.userService = userService;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }


    @Override
    public void selectOfficeWorkingTime(OfficeDTO officeDTO) {
        Office office = officeRepository.findByDay(officeDTO.getDay());
        office.setBegin(officeDTO.getBegin());
        office.setEnd(officeDTO.getEnd());
        office.setOpen(officeDTO.isOpen());
        if(!officeDTO.isOpen()) {
            office.setBegin(LocalTime.of(0,0));
            office.setEnd(LocalTime.of(0,0));
        }
        officeRepository.save(office);
    }


    @Override
    public void createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        User user = new User();
        user.setUsername(doctorDTO.getEmail());
        user.setPassword(doctorDTO.getSurname());
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setUser(user);
        userService.saveDoctor(user);
        doctorRepository.save(doctor);
    }

    @Override
    public void removeDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    @Override
    public void removePatient(Patient patient) {
            patientRepository.delete(patient);
    }

    @Override
    public void setTreatmentPrice(BigDecimal bigDecimal, String name) {

    }

    @Override
    public void changeAdminData(AdminDTO adminDTO, CurrentUser currentUser) {
        User user = userRepository.findByUsername(currentUser.getUser().getUsername());
        Admin admin = new Admin();
        if (adminRepository.findAdminByUserId(user.getId()) != null) {
            admin = adminRepository.findAdminByUserId(user.getId());
        }
        admin.setEmail(adminDTO.getEmail());
        admin.setName(adminDTO.getName());
        admin.setSurname(adminDTO.getSurname());
        admin.setUser(user);
        adminRepository.save(admin);
    }
}

