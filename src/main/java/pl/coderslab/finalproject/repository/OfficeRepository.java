package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Long> {

//    @Query("select u from Office where day = ?1")
//    Office findByDay(String day);

    Office findByDay(String Day);

}
