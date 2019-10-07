package az.pashabank.exam.notifier.service;

import az.pashabank.exam.notifier.model.CityDto;
import az.pashabank.exam.notifier.model.WeatherDto;
import az.pashabank.exam.notifier.wrapper.CityWrapper;

import java.util.List;

public interface NotifierService {
    List<WeatherDto> getWeatherInfoByCity(CityWrapper cityWrapper);
}
