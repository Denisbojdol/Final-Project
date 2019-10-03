package pl.coderslab.finalproject.repository;

import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findPatientByUserId(Long id);
}
