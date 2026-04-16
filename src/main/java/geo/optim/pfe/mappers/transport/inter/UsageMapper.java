package geo.optim.pfe.mappers.transport.inter;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.transport.UsageReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.UsageWriteDto;
import geo.optim.pfe.entities.transport.Usage;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;

@Mapper(
    componentModel = "spring",
    uses = {
        CollaboraterMapper.class,
        VehicleMapper.class
    },
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UsageMapper {
    public UsageReadDto toDTO(Usage usage);
    public Usage toEntity(UsageWriteDto usageWriteDto);
    public List<UsageReadDto> toDTOList(List<Usage> usages);
}
