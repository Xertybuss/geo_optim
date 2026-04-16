package geo.optim.pfe.mappers.transport.inter;

import java.util.List;

import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.transport.TripReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.TripWriteDto;
import geo.optim.pfe.entities.transport.Trip;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;

@Mapper(
    componentModel = "spring",
    uses = {ConstParameterMapper.class, TravelMapper.class, CompanyMapper.class},
    injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR
)
public interface TripMapper {
    public TripReadDto toDTO(Trip trip);
    public Trip toEntity(TripWriteDto tripWriteDto);
    public List<TripReadDto> toDTOList(List<Trip> trips);
}
