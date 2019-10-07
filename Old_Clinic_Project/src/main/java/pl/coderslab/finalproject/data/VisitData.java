package pl.coderslab.finalproject.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.entity.Treatment;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class VisitData {


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime visitData;

    private boolean smsInformation;

    private boolean confirm;

    @OneToOne
    private Physiotherapist physiotherapist;

    @OneToOne
    private Client client;

    @OneToOne
    private Treatment treatment;

}
