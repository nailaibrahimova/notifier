package az.pashabank.exam.notifier.controller;

import az.pashabank.exam.notifier.model.WeatherDto;
import az.pashabank.exam.notifier.service.NotifierService;
import az.pashabank.exam.notifier.wrapper.CityWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notifier")
public class NotifierController {

    private NotifierService notifierService;

    private static CityWrapper cities = new CityWrapper();

    private Logger logger = LoggerFactory.getLogger(NotifierController.class);

    public NotifierController(NotifierService notifierService) {
        this.notifierService = notifierService;
    }

    @PostMapping("getCities")
    public void getCities(@RequestBody CityWrapper cityWrapper){
        logger.info("ActionLog.getCities");
        this.cities = cityWrapper;
    }

    @GetMapping("getByCities")
    @Scheduled(fixedRate = 60000)
    public List<WeatherDto> getByCities(){
        logger.info("ActionLog.getByCities");
        return notifierService.getWeatherInfoByCity(cities);
    }
}
