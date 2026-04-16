package geo.optim.pfe.mappers.user;

import java.util.List;

import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.user.ProfileReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.ProfileWriteDto;
import geo.optim.pfe.entities.user.Profile;

@Mapper(componentModel = "spring")
public class ProfileMapperImpl implements ProfileMapper {
    private final AccountUserMapper accountUserMapper;
    private final PermissionMapper permissionMapper;

    public ProfileMapperImpl(AccountUserMapper accountUserMapper, PermissionMapper permissionMapper) {
        this.accountUserMapper = accountUserMapper;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public ProfileReadDto toDTO(Profile profile) {
        if (profile == null) {
            return null;
        }
        return new ProfileReadDto(
            profile.getId(),
            profile.getCodeProfile(),
            profile.getLabel(),
            accountUserMapper.toDTOList(profile.getAccounts()),
            permissionMapper.toDTOList(profile.getPermissions())
        );
    }

    @Override
    public Profile toEntity(ProfileWriteDto profileWriteDto) {
        if (profileWriteDto == null) {
            return null;
        }
        Profile profile = new Profile();
        profile.setCodeProfile(profileWriteDto.getCodeProfile());
        profile.setLabel(profileWriteDto.getLabel());
        return profile;
    }

    @Override
    public List<ProfileReadDto> toDTOList(List<Profile> profiles) {
        if (profiles == null) {
            return null;
        }
        return profiles.stream()
                .map(this::toDTO)
                .toList();
    }
}
