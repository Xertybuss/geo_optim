package geo.optim.pfe.mappers.organization.inter;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.organization.CollaboraterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CollaboraterWriteDto;
import geo.optim.pfe.entities.organization.Collaborater;

@Mapper(
    componentModel = "spring",
    uses = CompanyMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface CollaboraterMapper {
    public CollaboraterReadDto toDTO(Collaborater collaborater);
    public Collaborater toCollaborater(CollaboraterWriteDto collaboraterWriteDto);
    public List<CollaboraterReadDto> toDTOList(List<Collaborater> collaboraters);
}