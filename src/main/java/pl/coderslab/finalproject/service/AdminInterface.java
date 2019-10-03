package pl.coderslab.finalproject.service;


import pl.coderslab.finalproject.data.AdminDTO;
import pl.coderslab.finalproject.data.DoctorDTO;
import pl.coderslab.finalproject.data.OfficeDTO;
import pl.coderslab.finalproject.entity.Doctor;
import pl.coderslab.finalproject.entity.Patient;
import pl.coderslab.finalproject.security.securityService.CurrentUser;

import java.math.BigDecimal;

public interface AdminInterface {

        void selectOfficeWorkingTime(OfficeDTO officeDTO);

        void createDoctor(DoctorDTO doctorDTO);

        void removeDoctor(Doctor doctor);

        void removePatient(Patient patient);

        void setTreatmentPrice(BigDecimal bigDecimal, String name);

        void changeAdminData(AdminDTO adminDTO, CurrentUser currentUser);


}
