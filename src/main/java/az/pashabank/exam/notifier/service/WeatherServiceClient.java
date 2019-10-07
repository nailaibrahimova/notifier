package az.pashabank.exam.notifier.service;

import az.pashabank.exam.notifier.exception.WeatherException;
import az.pashabank.exam.notifier.model.WeatherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "weatherServiceClient", url = "localhost:8080/weather")
public interface WeatherServiceClient {
    @GetMapping("getByCity/{city}")
    List<WeatherDto> getWeatherByCity(@PathVariable String city);
}
