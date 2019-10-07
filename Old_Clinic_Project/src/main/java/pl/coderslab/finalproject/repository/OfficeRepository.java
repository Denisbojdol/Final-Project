package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Office;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Long> {

    List<Office> findAllBy();
}
