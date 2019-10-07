package az.pashabank.exam.notifier.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    @JsonIgnore
    private Long id;

    private double temperature;

    private LocalDate date;

    @NotNull
    private String city;
}
