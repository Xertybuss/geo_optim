package geo.optim.pfe.mappers.user;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.user.ProfileReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.ProfileWriteDto;
import geo.optim.pfe.entities.user.Profile;

@Mapper(
    componentModel = "spring",
    uses = {
        AccountUserMapper.class,
        PermissionMapper.class
    },
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ProfileMapper {
    public ProfileReadDto toDTO(Profile profile);
    public Profile toEntity(ProfileWriteDto profileWriteDto);
    public List<ProfileReadDto> toDTOList(List<Profile> profiles);
}
