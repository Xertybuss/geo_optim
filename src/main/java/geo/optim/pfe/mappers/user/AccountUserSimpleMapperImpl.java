package geo.optim.pfe.mappers.user;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.user.AccountUserSimpleReadDto;
import geo.optim.pfe.entities.user.AccountUser;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;

@Component
public class AccountUserSimpleMapperImpl implements AccountUserSimpleMapper {
    private final ObjectProvider<CompanyMapper> companyMapperProvider;

    public AccountUserSimpleMapperImpl(ObjectProvider<CompanyMapper> companyMapperProvider) {
        this.companyMapperProvider = companyMapperProvider;
    }

    @Override
    public AccountUserSimpleReadDto toDTO(AccountUser accountUser) {
        if (accountUser == null) {
            return null;
        }
        return new AccountUserSimpleReadDto(
            accountUser.getId(),
            accountUser.getFirstName(),
            accountUser.getLastName(),
            accountUser.getUsername(),
            accountUser.getPhoneNumber(),
            accountUser.isActivated(),
            companyMapperProvider.getObject().toDTO(accountUser.getCompany())
        );
    }
}
