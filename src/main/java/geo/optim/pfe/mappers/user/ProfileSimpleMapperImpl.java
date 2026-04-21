package geo.optim.pfe.mappers.user;

import org.springframework.stereotype.Component;

import geo.optim.pfe.dtos.readDtos.user.ProfileSimpleReadDto;
import geo.optim.pfe.entities.user.Profile;

@Component
public class ProfileSimpleMapperImpl implements ProfileSimpleMapper {
    @Override
    public ProfileSimpleReadDto toDTO(Profile profile) {
        if (profile == null) {
            return null;
        }
        return new ProfileSimpleReadDto(
            profile.getId(),
            profile.getCodeProfile(),
            profile.getLabel()
        );
    }
}
