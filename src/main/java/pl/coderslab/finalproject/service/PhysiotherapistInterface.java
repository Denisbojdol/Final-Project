package pl.coderslab.finalproject.service;

import java.time.LocalDateTime;

public interface PhysiotherapistInterface {



    void visitAuthorization(boolean accept,Long id);

    void setWorkingTime(LocalDateTime begin, LocalDateTime end, String Day,Long id);


    void setTreatmentMethods();

    void writeRecommendationToClient(LocalDateTime data, Long id, String description);

}
