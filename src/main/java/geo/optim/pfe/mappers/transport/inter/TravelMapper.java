package geo.optim.pfe.mappers.transport.inter;

import java.util.List;

import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.transport.TravelReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.TravelWriteDto;
import geo.optim.pfe.entities.transport.Travel;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;

@Mapper(
    componentModel = "spring",
    uses = CollaboraterMapper.class,
    injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR
)
public interface TravelMapper {
    public TravelReadDto toDTO(Travel travel);
    public Travel toEntity(TravelWriteDto travelDto);
    public List<TravelReadDto> toDTOList(List<Travel> travels);
}
