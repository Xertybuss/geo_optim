package geo.optim.pfe.mappers.transport.inter;

import java.util.List;

import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.transport.ConstParameterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.ConstParameterWriteDto;
import geo.optim.pfe.entities.transport.ConstParameter;

@Mapper(
    componentModel = "spring",
    uses = TripMapper.class,
    injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR
)
public interface ConstParameterMapper {
    public ConstParameterReadDto toDTO(ConstParameter constParameter);
    public ConstParameter toEntity(ConstParameterWriteDto constParameterDto);
    public List<ConstParameterReadDto> toDTOList(List<ConstParameter> constParameters);
}
