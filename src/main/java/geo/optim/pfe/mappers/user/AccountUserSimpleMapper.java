package geo.optim.pfe.mappers.user;

import geo.optim.pfe.dtos.readDtos.user.AccountUserSimpleReadDto;
import geo.optim.pfe.entities.user.AccountUser;

public interface AccountUserSimpleMapper {
    AccountUserSimpleReadDto toDTO(AccountUser accountUser);
}
