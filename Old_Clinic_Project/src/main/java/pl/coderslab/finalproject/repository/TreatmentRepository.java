package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Treatment;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment,Long> {

    Treatment findByName(String name);
    List<Treatment> findAllBy();
}
