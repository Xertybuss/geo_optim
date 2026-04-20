package geo.optim.pfe.mappers.organization.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.organization.ClientApplicationReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.ClientApplicationWriteDto;
import geo.optim.pfe.entities.organization.ClientApplication;
import geo.optim.pfe.mappers.organization.inter.ClientApplicationMapper;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.repositories.organization.CompanyRepository;

@Component
public class ClientApplicationMapperImpl implements ClientApplicationMapper {
    private final ObjectProvider<CompanyMapper> companyMapperProvider;
    private final CompanyRepository companyRepository;

    public ClientApplicationMapperImpl(ObjectProvider<CompanyMapper> companyMapperProvider, CompanyRepository companyRepository) {
        this.companyMapperProvider = companyMapperProvider;
        this.companyRepository = companyRepository;
    }

    @Override
    public ClientApplicationReadDto toDTO(ClientApplication clientApplication) {
        if (clientApplication == null) return null;
        return new ClientApplicationReadDto(
            clientApplication.getId(),
            clientApplication.getCode_app(),
            clientApplication.getLabel(),
            clientApplication.getApi_key(),
            clientApplication.getMax_transaction_day(),
            clientApplication.getActivated(),
            companyMapperProvider.getObject().toDTO(clientApplication.getCompany())
        );
    }

    @Override
    public ClientApplication toEntity(ClientApplicationWriteDto clientApplicationWriteDto) {
        if (clientApplicationWriteDto == null) return null;
        ClientApplication clientApplication = new ClientApplication();
        clientApplication.setCode_app(clientApplicationWriteDto.getCode_app());
        clientApplication.setLabel(clientApplicationWriteDto.getLabel());
        clientApplication.setApi_key(clientApplicationWriteDto.getApi_key());
        clientApplication.setMax_transaction_day(clientApplicationWriteDto.getMax_transaction_day());
        clientApplication.setActivated(clientApplicationWriteDto.getActivated());
        clientApplication.setCompany(companyRepository.findById(clientApplicationWriteDto.getCompanyId()).orElse(null));
        return clientApplication;
    }

    @Override
    public List<ClientApplicationReadDto> toDTOList(List<ClientApplication> clientApplications) {
        return null;
    }

}
