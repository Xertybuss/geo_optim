package geo.optim.pfe.mappers.organization.inter;

import java.util.List;

import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CompanyWriteDto;
import geo.optim.pfe.entities.organization.Company;
import geo.optim.pfe.mappers.transport.inter.TripMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;
import geo.optim.pfe.mappers.user.AccountUserMapper;

@Mapper(
    componentModel = "spring",
    uses = {
        VehicleMapper.class,
        AccountUserMapper.class,
        CollaboraterMapper.class,
        TripMapper.class,
    },
    injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR
)
public interface CompanyMapper {
    public CompanyReadDto toDTO(Company company);
    public Company toEntity(CompanyWriteDto companyWriteDto);
    public List<CompanyReadDto> toDTOList(List<Company> companies);
}
