package pl.coderslab.finalproject.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.finalproject.entity.Client;
import pl.coderslab.finalproject.entity.Physiotherapist;
import pl.coderslab.finalproject.entity.Treatment;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class VisitData {


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime visitData;

    private boolean smsInformation;

    @OneToOne
    @NotNull
    private Physiotherapist physiotherapist;

    @OneToOne
    @NotNull
    private Client client;

    @OneToOne
    @NotNull
    private Treatment treatment;

}
