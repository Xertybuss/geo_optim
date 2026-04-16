package geo.optim.pfe.mappers.user;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.user.PermissionReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.PermissionWriteDto;
import geo.optim.pfe.entities.user.Permission;
import geo.optim.pfe.repositories.user.ProfileRepository;

public class PermissionMapperImpl implements PermissionMapper {
    private final ProfileMapper profileMapper;
    private final ProfileRepository profileRepository;

    public PermissionMapperImpl(ProfileMapper profileMapper, ProfileRepository profileRepository) {
        this.profileMapper = profileMapper;
        this.profileRepository = profileRepository;
    }

    @Override
    public PermissionReadDto toDTO(Permission permission) {
        if (permission == null) {
            return null;
        }
        return new PermissionReadDto(
            permission.getId(),
            permission.getCodePermission(),
            permission.getLabel(),
            profileMapper.toDTO(permission.getProfile())
        );
    }

    @Override
    public Permission toEntity(PermissionWriteDto permissionWriteDto) {
        if (permissionWriteDto == null) {
            return null;
        }
        Permission permission = new Permission();
        permission.setCodePermission(permissionWriteDto.getCodePermission());
        permission.setLabel(permissionWriteDto.getLabel());
        permission.setProfile(profileRepository.findById(permissionWriteDto.getProfileId()).orElse(null));
        return permission;
    }

    @Override
    public List<PermissionReadDto> toDTOList(List<Permission> permissions) {
        if (permissions == null) {
            return null;
        }
        return permissions.stream()
            .map(this::toDTO)
            .toList();
    }
}
