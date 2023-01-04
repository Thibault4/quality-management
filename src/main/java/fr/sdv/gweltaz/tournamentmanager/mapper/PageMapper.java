package fr.sdv.gweltaz.tournamentmanager.mapper;

import fr.sdv.gweltaz.tournamentmanager.DTO.PageDto;
import fr.sdv.gweltaz.tournamentmanager.DTO.PaginationContext;
import fr.sdv.gweltaz.tournamentmanager.DTO.TournamentCreateDTO;
import fr.sdv.gweltaz.tournamentmanager.DTO.TournamentDTO;
import fr.sdv.gweltaz.tournamentmanager.model.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface PageMapper {

    @Mapping(target = "page", source = "number")
    @Mapping(target = "count", source = "numberOfElements")
    @Mapping(target = "pageSize", source = "size")
    @Mapping(target = "total", source = "totalElements")
    PaginationContext toPaginationContext(Page<?> page);
}
