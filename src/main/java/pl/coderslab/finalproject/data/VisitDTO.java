package pl.coderslab.finalproject.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.finalproject.entity.Doctor;
import pl.coderslab.finalproject.entity.Patient;
import pl.coderslab.finalproject.entity.Treatment;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class VisitDTO {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitData;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime visitTime;

    private boolean smsInformation;

    private boolean confirm;

    @OneToOne
    private Doctor doctor;

    @OneToOne
    private Patient patient;

    @OneToOne
    private Treatment treatment;


}
