package az.pashabank.exam.notifier.wrapper;

import az.pashabank.exam.notifier.model.CityDto;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CityWrapper {

    private List<CityDto> cityDtos;
}
