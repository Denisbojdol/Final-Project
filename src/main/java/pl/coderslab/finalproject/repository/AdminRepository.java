package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findAdminByUserId(Long id);
}
