package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Physiotherapist;

@Repository
public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist,Long> {
}
