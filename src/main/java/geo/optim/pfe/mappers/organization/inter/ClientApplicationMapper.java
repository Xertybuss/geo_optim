package geo.optim.pfe.mappers.organization.inter;

import java.util.List;

import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.organization.ClientApplicationReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.ClientApplicationWriteDto;
import geo.optim.pfe.entities.organization.ClientApplication;

@Mapper(
    componentModel = "spring",
    uses = {CompanyMapper.class},
    injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR
)
public interface ClientApplicationMapper {
    public ClientApplicationReadDto toDTO(ClientApplication clientApplication);
    public ClientApplication toEntity(ClientApplicationWriteDto clientApplicationWriteDto);
    public List<ClientApplicationReadDto> toDTOList(List<ClientApplication> clientApplications);
}
