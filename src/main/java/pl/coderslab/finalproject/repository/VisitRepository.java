package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {
}
