package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.security.securityDTO.UserDTO;

public interface PatientInterface {

    void createPatient(UserDTO userDTO);
}
