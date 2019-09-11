package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.WorkSchedule;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule,Long> {
}
