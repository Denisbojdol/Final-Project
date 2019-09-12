package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.PatientCard;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findClientByUserId(Long id);
}
