package pl.coderslab.finalproject.security.securityRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.security.securityEntity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
