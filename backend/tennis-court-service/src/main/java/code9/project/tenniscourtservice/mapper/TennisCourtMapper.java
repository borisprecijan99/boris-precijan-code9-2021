package code9.project.tenniscourtservice.mapper;

import code9.project.tenniscourtservice.dto.TennisCourtDto;
import code9.project.tenniscourtservice.model.TennisCourtEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TennisCourtMapper {

    TennisCourtDto toTennisCourtDto(TennisCourtEntity tennisCourtEntity);
    TennisCourtEntity toTennisCourtEntity(TennisCourtDto tennisCourtDto);
    List<TennisCourtDto> toTennisCourtDtos(List<TennisCourtEntity> tennisCourtEntityList);

}
