package az.pashabank.exam.notifier.service;

import az.pashabank.exam.notifier.dao.NotifierRepository;
import az.pashabank.exam.notifier.dao.entity.DataEntity;
import az.pashabank.exam.notifier.mapper.MapperInterface;
import az.pashabank.exam.notifier.model.CityDto;
import az.pashabank.exam.notifier.model.WeatherDto;
import az.pashabank.exam.notifier.wrapper.CityWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotifierServiceImpl implements NotifierService {

    private NotifierRepository notifierRepository;

    private WeatherServiceClient weatherServiceClient;

    public NotifierServiceImpl(NotifierRepository notifierRepository, WeatherServiceClient weatherServiceClient) {
        this.notifierRepository = notifierRepository;
        this.weatherServiceClient = weatherServiceClient;
    }

    @Override
    public List<WeatherDto> getWeatherInfoByCity(CityWrapper cityWrapper) {
        List<WeatherDto> weatherDtos = new ArrayList<>();
        for (CityDto city : cityWrapper.getCityDtos()) {
            List<WeatherDto> dtos = weatherServiceClient.getWeatherByCity(city.getName());
            weatherDtos.addAll(dtos);
        }
        List<DataEntity> dataEntities = notifierRepository.findAll();
        if (CollectionUtils.isEmpty(dataEntities)) {
            dataEntities = weatherDtos.stream().map(MapperInterface.INSTANCE::mapDtoToEntity)
                    .collect(Collectors.toList());
            notifierRepository.saveAll(dataEntities);
        } else {
            notifierRepository.deleteAll();
            dataEntities = weatherDtos.stream().map(MapperInterface.INSTANCE::mapDtoToEntity)
                    .collect(Collectors.toList());
            notifierRepository.saveAll(dataEntities);
        }
        return weatherDtos;
    }
}
