package geo.optim.pfe.mappers.organization.impl;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CompanyWriteDto;
import geo.optim.pfe.entities.organization.Company;
import geo.optim.pfe.mappers.organization.inter.ClientApplicationMapper;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.mappers.transport.inter.TripMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;
import geo.optim.pfe.mappers.user.AccountUserMapper;

public class CompanyMapperImpl implements CompanyMapper {
    private final VehicleMapper vehicleMapper;
    private final AccountUserMapper accountUserMapper;
    private final CollaboraterMapper collaboraterMapper;
    private final TripMapper tripMapper;
    private final ClientApplicationMapper clientApplicationMapper;

    public CompanyMapperImpl(VehicleMapper vehicleMapper, AccountUserMapper accountUserMapper,
                             CollaboraterMapper collaboraterMapper, TripMapper tripMapper,
                             ClientApplicationMapper clientApplicationMapper) {
        this.vehicleMapper = vehicleMapper;
        this.accountUserMapper = accountUserMapper;
        this.collaboraterMapper = collaboraterMapper;
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
            vehicleMapper.toDTOList(company.getVehicles()),
            accountUserMapper.toDTOList(company.getAccounts()),
            collaboraterMapper.toDTOList(company.getCollaboraters()),
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
