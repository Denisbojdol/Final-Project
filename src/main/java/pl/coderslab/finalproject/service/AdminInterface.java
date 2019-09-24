package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.data.AdminData;
import pl.coderslab.finalproject.data.OfficeData;
import pl.coderslab.finalproject.data.PhysiotherapistData;
import pl.coderslab.finalproject.entity.Admin;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.entity.Visit;
import pl.coderslab.finalproject.securityEntity.User;
import pl.coderslab.finalproject.securityEntity.securityService.CurrentUser;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public interface AdminInterface {

        void selectOfficeWorkingTime(LocalDateTime begin,LocalDateTime end,boolean open);

        void editOfficeWorkingTime(OfficeData officeData,Long id);

        void createPhysiotherapist(PhysiotherapistData physiotherapistData);

        void setOfficeScheduleInformation(String information);

        void removePhysiotherapist(Physiotherapist physiotherapist);

        void removeClient(Client client);

        void setTreatmentPrice(BigDecimal bigDecimal,String name);

        void changeAdminData(AdminData adminData, CurrentUser currentUser);


}
