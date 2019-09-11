package pl.coderslab.finalproject.service;


import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.entity.Treatment;

import java.time.LocalDateTime;

public interface ClientInterface {

    void selectVisit(LocalDateTime localDateTime, Client client, Physiotherapist physiotherapist, Treatment treatment);

    void selectHistory(Long id);

    void createAccount(String name,String surname,String email);

    void deleteAccount(Long id);

    void editAccount(Long id,String name,String surname,String email);







}
