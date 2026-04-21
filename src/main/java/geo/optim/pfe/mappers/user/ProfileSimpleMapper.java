package geo.optim.pfe.mappers.user;

import geo.optim.pfe.dtos.readDtos.user.ProfileSimpleReadDto;
import geo.optim.pfe.entities.user.Profile;

public interface ProfileSimpleMapper {
    ProfileSimpleReadDto toDTO(Profile profile);
}
