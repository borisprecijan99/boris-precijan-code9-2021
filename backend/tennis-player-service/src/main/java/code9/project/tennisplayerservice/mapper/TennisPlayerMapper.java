package code9.project.tennisplayerservice.mapper;

import org.mapstruct.Mapper;

import code9.project.tennisplayerservice.dto.TennisPlayerDto;
import code9.project.tennisplayerservice.model.TennisPlayerEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TennisPlayerMapper {

    TennisPlayerDto toTennisPlayerDto(TennisPlayerEntity tennisPlayerEntity);
    TennisPlayerEntity toTennisPlayerEntity(TennisPlayerDto tennisPlayerDto);
    List<TennisPlayerDto> toTennisPlayerDtos(List<TennisPlayerEntity> tennisPlayerEntityList);

}
