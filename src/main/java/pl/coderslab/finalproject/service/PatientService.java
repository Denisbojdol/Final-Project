package pl.coderslab.finalproject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.entity.Patient;
import pl.coderslab.finalproject.repository.PatientRepository;
import pl.coderslab.finalproject.security.securityDTO.UserDTO;
import pl.coderslab.finalproject.security.securityRepository.UserRepository;

@Service
public class PatientService implements PatientInterface {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    public PatientService(UserRepository userRepository, PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
    }


    @Override
    public void createPatient(UserDTO userDTO) {
        Patient patient = new Patient();
        patient.setEmail(userDTO.getUsername());
        patient.setName(userDTO.getName());
        patient.setSurname(userDTO.getSurname());
        patient.setUser(userRepository.findByUsername(userDTO.getUsername()));
        patientRepository.save(patient);
    }
}
