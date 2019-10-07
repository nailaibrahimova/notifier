package az.pashabank.exam.notifier.mapper;

import az.pashabank.exam.notifier.dao.entity.DataEntity;
import az.pashabank.exam.notifier.model.WeatherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperInterface {

    MapperInterface INSTANCE = Mappers.getMapper(MapperInterface.class);

    DataEntity mapDtoToEntity(WeatherDto weatherDto);

    WeatherDto mapEntityToDto(DataEntity dataEntity);
}
