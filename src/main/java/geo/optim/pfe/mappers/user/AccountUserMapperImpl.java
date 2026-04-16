package geo.optim.pfe.mappers.user;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.user.AccountUserReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.AccountUserWriteDto;
import geo.optim.pfe.entities.user.AccountUser;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;
import geo.optim.pfe.repositories.organization.CompanyRepository;
import geo.optim.pfe.repositories.user.ProfileRepository;

public class AccountUserMapperImpl implements AccountUserMapper {
    private final CompanyMapper companyMapper;
    private final VehicleMapper vehicleMapper;
    private final ProfileMapper profileMapper;
    private final CompanyRepository companyRepository;
    private final ProfileRepository profileRepository;

    public AccountUserMapperImpl(CompanyMapper companyMapper, VehicleMapper vehicleMapper, ProfileMapper profileMapper, CompanyRepository companyRepository, ProfileRepository profileRepository) {
        this.companyMapper = companyMapper;
        this.vehicleMapper = vehicleMapper;
        this.profileMapper = profileMapper;
        this.companyRepository = companyRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public AccountUserReadDto toDTO(AccountUser accountUser) {
        if (accountUser == null) {
            return null;
        }
        return new AccountUserReadDto(
            accountUser.getId(),
            accountUser.getFirstName(),
            accountUser.getLastName(),
            accountUser.getUsername(),
            accountUser.getPhoneNumber(),
            accountUser.isActivated(),
            companyMapper.toDTO(accountUser.getCompany()),
            profileMapper.toDTO(accountUser.getProfile()),
            vehicleMapper.toDTOList(accountUser.getVehicles())
        );
    }

    @Override
    public AccountUser toEntity(AccountUserWriteDto accountUserWriteDto) {
        if (accountUserWriteDto == null) {
            return null;
        }
        AccountUser accountUser = new AccountUser();
        accountUser.setFirstName(accountUserWriteDto.getFirstName());
        accountUser.setLastName(accountUserWriteDto.getLastName());
        accountUser.setPhoneNumber(accountUserWriteDto.getPhoneNumber());
        accountUser.setCompany(companyRepository.findById(accountUserWriteDto.getCompanyId()).orElse(null));
        accountUser.setProfile(profileRepository.findById(accountUserWriteDto.getProfileId()).orElse(null));
        return accountUser;
    }

    @Override
    public List<AccountUserReadDto> toDTOList(List<AccountUser> accountUsers) {
        if (accountUsers == null) {
            return null;
        }
        return accountUsers.stream()
            .map(this::toDTO)
            .toList();
    }
}
