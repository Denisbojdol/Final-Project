package pl.coderslab.finalproject.service;

import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.entity.Treatment;
import pl.coderslab.finalproject.entity.Visit;
import pl.coderslab.finalproject.repository.ClientRepository;
import pl.coderslab.finalproject.repository.PatientCardRepository;
import pl.coderslab.finalproject.repository.VisitRepository;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.UserRepository;

import java.time.LocalDateTime;

@Service
public class ClientService implements ClientInterface {


    private UserRepository userRepository;
    private VisitRepository visitRepository;
    private PatientCardRepository patientCardRepository;
    private ClientRepository clientRepository;


    public ClientService(UserRepository userRepository, VisitRepository visitRepository, PatientCardRepository patientCardRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.visitRepository = visitRepository;
        this.patientCardRepository = patientCardRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void selectVisit(LocalDateTime data, Client client, Physiotherapist physiotherapist, Treatment treatment) {
        Visit visit = new Visit();
        visit.setClient(client);
        visit.setVisitData(data);
        visit.setPhysiotherapist(physiotherapist);
        visit.setTreatment(treatment);
        visit.setSmsInformation(false);
        visitRepository.save(visit);
    }


    @Override
    public void selectHistory(Long id) {
        patientCardRepository.findAllByClientId(id);
    }


    @Override
    public void deleteAccount(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }

    @Override
    public void createAccount(String name, String surname, String email, User user) {
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setUser(user);
        clientRepository.save(client);
    }

    @Override
    public void editAccount(Long id, String name, String surname, String email) {
        Client client = clientRepository.getOne(id);
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        clientRepository.save(client);

    }
}
