package geo.optim.pfe.mappers.transport.inter;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import geo.optim.pfe.dtos.readDtos.transport.VehicleReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.VehicleWriteDto;
import geo.optim.pfe.entities.transport.Vehicle;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;

@Mapper(
    componentModel = "spring",
    uses = {CompanyMapper.class, /*AccountUserMapper.class, UsageMapper.class*/},
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface VehicleMapper {
    public VehicleReadDto toDTO(Vehicle vehicle);
    public Vehicle toEntity(VehicleWriteDto vehicleWriteDto);
    public List<VehicleReadDto> toDTOList(List<Vehicle> vehicles);
}
