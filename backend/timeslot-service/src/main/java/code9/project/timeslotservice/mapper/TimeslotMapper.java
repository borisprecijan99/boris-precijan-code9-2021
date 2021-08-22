package code9.project.timeslotservice.mapper;

import code9.project.timeslotservice.dto.TimeslotDto;
import code9.project.timeslotservice.model.TimeslotEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeslotMapper {

    TimeslotDto toTimeslotDto(TimeslotEntity timeslotEntity);
    TimeslotEntity toTimeslotEntity(TimeslotDto timeslotDto);
    List<TimeslotDto> toTimeslotDtos(List<TimeslotEntity> timeslotEntityList);

}
