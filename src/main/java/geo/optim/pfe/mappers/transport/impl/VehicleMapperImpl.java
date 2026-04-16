package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.transport.VehicleReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.VehicleWriteDto;
import geo.optim.pfe.entities.transport.Vehicle;
import geo.optim.pfe.enums.TypeVehicle;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.mappers.transport.inter.UsageMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;
import geo.optim.pfe.mappers.user.AccountUserMapper;
import geo.optim.pfe.repositories.organization.CompanyRepository;

public class VehicleMapperImpl implements VehicleMapper {
    private final CompanyMapper companyMapper;
    private final AccountUserMapper accountUserMapper;
    private final UsageMapper usageMapper;
    private final CompanyRepository companyRepository;

    public VehicleMapperImpl(CompanyMapper companyMapper, AccountUserMapper accountUserMapper, UsageMapper usageMapper, CompanyRepository companyRepository) {
        this.companyMapper = companyMapper;
        this.accountUserMapper = accountUserMapper;
        this.usageMapper = usageMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public VehicleReadDto toDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        return new VehicleReadDto(
            vehicle.getId(),
            vehicle.getImei(),
            vehicle.getImmatriculation(),
            vehicle.getLabel(),
            vehicle.getVehicleType().getLabel(),
            vehicle.getCapacityPlaces(),
            vehicle.getCapacityWeight(),
            companyMapper.toDTO(vehicle.getCompany()),
            accountUserMapper.toDTO(vehicle.getAccountUser()),
            usageMapper.toDTOList(vehicle.getUsages())
        );   
    }

    @Override
    public Vehicle toEntity(VehicleWriteDto vehicleWriteDto) {
        if (vehicleWriteDto == null) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setImei(vehicleWriteDto.getImei());
        vehicle.setImmatriculation(vehicleWriteDto.getImmatriculation());
        vehicle.setLabel(vehicleWriteDto.getLabel());
        vehicle.setVehicleType(TypeVehicle.fromLabel(vehicleWriteDto.getVehicleType()));
        vehicle.setCapacityPlaces(vehicleWriteDto.getCapacityPlaces());
        vehicle.setCapacityWeight(vehicleWriteDto.getCapacityWeight());
        vehicle.setCompany(companyRepository.findById(vehicleWriteDto.getCompany_id()).orElse(null));
        return vehicle;
    }

    @Override
    public List<VehicleReadDto> toDTOList(List<Vehicle> vehicles) {
        if (vehicles == null) {
            return null;
        }
        return vehicles.stream()
            .map(this::toDTO)
            .toList();
    }

}
