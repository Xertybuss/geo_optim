package geo.optim.pfe.mappers.organization.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CompanyWriteDto;
import geo.optim.pfe.entities.organization.Company;
import geo.optim.pfe.mappers.organization.inter.ClientApplicationMapper;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.mappers.transport.inter.TripMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;
import geo.optim.pfe.mappers.user.AccountUserMapper;

@Component
public class CompanyMapperImpl implements CompanyMapper {
    private final ObjectProvider<VehicleMapper> vehicleMapperProvider;
    private final ObjectProvider<AccountUserMapper> accountUserMapperProvider;
    private final ObjectProvider<CollaboraterMapper> collaboraterMapperProvider;
    private final TripMapper tripMapper;
    private final ClientApplicationMapper clientApplicationMapper;

    public CompanyMapperImpl(ObjectProvider<VehicleMapper> vehicleMapperProvider, ObjectProvider<AccountUserMapper> accountUserMapperProvider,
                             ObjectProvider<CollaboraterMapper> collaboraterMapperProvider, TripMapper tripMapper,
                             ClientApplicationMapper clientApplicationMapper) {
        this.vehicleMapperProvider = vehicleMapperProvider;
        this.accountUserMapperProvider = accountUserMapperProvider;
        this.collaboraterMapperProvider = collaboraterMapperProvider;
        this.tripMapper = tripMapper;
        this.clientApplicationMapper = clientApplicationMapper;
    }

    @Override
    public CompanyReadDto toDTO(Company company) {
        return new CompanyReadDto(
            company.getId(),
            company.getCodeCompany(),
            company.getLabel(),
            company.getAddress(),
            company.getPhoneNumber(),
            vehicleMapperProvider.getObject().toDTOList(company.getVehicles()),
            accountUserMapperProvider.getObject().toDTOList(company.getAccounts()),
            collaboraterMapperProvider.getObject().toDTOList(company.getCollaboraters()),
            tripMapper.toDTOList(company.getTrips()),
            clientApplicationMapper.toDTOList(company.getClientApplications())
        );
    }

    @Override
    public Company toEntity(CompanyWriteDto companyWriteDto) {
        if (companyWriteDto == null) return null;
        Company company = new Company();
        company.setCodeCompany(companyWriteDto.getCodeCompany());
        company.setLabel(companyWriteDto.getLabel());
        company.setAddress(companyWriteDto.getAddress());
        company.setPhoneNumber(companyWriteDto.getPhoneNumber());
        return company;
    }

    @Override
    public List<CompanyReadDto> toDTOList(List<Company> companies) {
        return companies.stream()
            .map(this::toDTO)
            .toList();
    }
}
