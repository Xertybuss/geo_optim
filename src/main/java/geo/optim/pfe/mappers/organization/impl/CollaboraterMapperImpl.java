package geo.optim.pfe.mappers.organization.impl;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.organization.CollaboraterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CollaboraterWriteDto;
import geo.optim.pfe.entities.organization.Collaborater;
import geo.optim.pfe.enums.TypeCollab;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.repositories.organization.CompanyRepository;

public class CollaboraterMapperImpl implements CollaboraterMapper {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;

    public CollaboraterMapperImpl(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
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
            companyMapper.toDTO(collaborater.getCompany()),
            null,
            null
        );
    }

    @Override
    public Collaborater toCollaborater(CollaboraterWriteDto collaboraterWriteDto) {
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
