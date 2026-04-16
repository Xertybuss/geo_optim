package geo.optim.pfe.mappers.user;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.user.PermissionReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.PermissionWriteDto;
import geo.optim.pfe.entities.user.Permission;

@Mapper(
    componentModel = "spring",
    uses = {ProfileMapper.class},
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface PermissionMapper {
    public PermissionReadDto toDTO(Permission permission);
    public Permission toEntity(PermissionWriteDto permissionWriteDto);
    public List<PermissionReadDto> toDTOList(List<Permission> permissions);
}
