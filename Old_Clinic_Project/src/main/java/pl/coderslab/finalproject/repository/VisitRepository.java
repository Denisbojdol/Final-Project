package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Visit;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {

    List<Visit> findAllByClientId(Long id);
    List<Visit> findAllByPhysiotherapistId(Long id);
}
