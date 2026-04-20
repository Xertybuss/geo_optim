package geo.optim.pfe.mappers.user;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.user.ProfileReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.ProfileWriteDto;
import geo.optim.pfe.entities.user.Profile;

@Component
public class ProfileMapperImpl implements ProfileMapper {
    private final ObjectProvider<AccountUserMapper> accountUserMapperProvider;
    private final PermissionMapper permissionMapper;

    public ProfileMapperImpl(ObjectProvider<AccountUserMapper> accountUserMapperProvider, PermissionMapper permissionMapper) {
        this.accountUserMapperProvider = accountUserMapperProvider;
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
            accountUserMapperProvider.getObject().toDTOList(profile.getAccounts()),
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
