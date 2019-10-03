package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
