package geo.optim.pfe.mappers.organization.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.organization.CollaboraterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CollaboraterWriteDto;
import geo.optim.pfe.entities.organization.Collaborater;
import geo.optim.pfe.enums.TypeCollab;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.repositories.organization.CompanyRepository;

@Component
public class CollaboraterMapperImpl implements CollaboraterMapper {
    private final ObjectProvider<CompanyMapper> companyMapperProvider;
    private final CompanyRepository companyRepository;

    public CollaboraterMapperImpl(CompanyRepository companyRepository, ObjectProvider<CompanyMapper> companyMapperProvider) {
        this.companyRepository = companyRepository;
        this.companyMapperProvider = companyMapperProvider;
    }

    @Override
    public CollaboraterReadDto toDTO(Collaborater collaborater) {
        if (collaborater == null) return null;
        return new CollaboraterReadDto(
            collaborater.getId(),
            collaborater.getFirstName(),
            collaborater.getLastName(),
            collaborater.getPhoneNumber(),
            collaborater.getHomeLocation(),
            collaborater.getAddress(),
            collaborater.getCollabType().getLabel(),
            companyMapperProvider.getObject().toDTO(collaborater.getCompany()),
            null,
            null
        );
    }

    @Override
    public Collaborater toEntity(CollaboraterWriteDto collaboraterWriteDto) {
        if (collaboraterWriteDto == null) return null;
        Collaborater collaborater = new Collaborater();
        collaborater.setFirstName(collaboraterWriteDto.getFirstName());
        collaborater.setLastName(collaboraterWriteDto.getLastName());
        collaborater.setPhoneNumber(collaboraterWriteDto.getPhoneNumber());
        collaborater.setHomeLocation(collaboraterWriteDto.getHomeLocation());
        collaborater.setAddress(collaboraterWriteDto.getAddress());
        collaborater.setCollabType(TypeCollab.fromLabel(collaboraterWriteDto.getCollabType()));
        collaborater.setCompany(companyRepository.findById(collaboraterWriteDto.getCompany_id()).orElse(null));
        return collaborater;
    }

    @Override
    public List<CollaboraterReadDto> toDTOList(List<Collaborater> collaboraters) {
        if (collaboraters == null) return null;
        return collaboraters.stream()
            .map(this::toDTO)
            .toList();
    }
}
