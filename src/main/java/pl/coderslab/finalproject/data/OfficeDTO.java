package pl.coderslab.finalproject.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class OfficeDTO {

    @NotNull
    private boolean open;

    @NotEmpty
    private String day;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime begin;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime end;


}
