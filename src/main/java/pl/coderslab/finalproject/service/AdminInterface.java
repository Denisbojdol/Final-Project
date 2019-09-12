package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.entity.Visit;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public interface AdminInterface {

        void selectOfficeWorkingTime(LocalDateTime begin,LocalDateTime end,boolean open);

        void createPhysiotherapist(Physiotherapist physiotherapist);

        void setOfficeScheduleInformation(String information);

        void removePhysiotherapist(Physiotherapist physiotherapist);

        void removeClient(Client client);

        void setTreatmentPrice(BigDecimal bigDecimal,String name);


}
