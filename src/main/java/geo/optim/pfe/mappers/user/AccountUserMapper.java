package geo.optim.pfe.mappers.user;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.user.AccountUserReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.AccountUserWriteDto;
import geo.optim.pfe.entities.user.AccountUser;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;

@Mapper(
    componentModel = "spring",
    uses = {VehicleMapper.class,
            CompanyMapper.class
        },
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AccountUserMapper {
    public AccountUserReadDto toDTO(AccountUser accountUser);
    public AccountUser toEntity(AccountUserWriteDto accountUserWriteDto);
    public List<AccountUserReadDto> toDTOList(List<AccountUser> accountUsers);
}
