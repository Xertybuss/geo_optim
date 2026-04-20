package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import geo.optim.pfe.dtos.readDtos.transport.VehicleReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.VehicleWriteDto;
import geo.optim.pfe.entities.transport.Vehicle;
import geo.optim.pfe.enums.TypeVehicle;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.mappers.transport.inter.UsageMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;
import geo.optim.pfe.mappers.user.AccountUserMapper;
import geo.optim.pfe.repositories.organization.CompanyRepository;

@Component
public class VehicleMapperImpl implements VehicleMapper {
    private final ObjectProvider<CompanyMapper> companyMapperProvider;
    private final ObjectProvider<AccountUserMapper> accountUserMapperProvider;
    private final ObjectProvider<UsageMapper> usageMapperProvider;
    private final CompanyRepository companyRepository;

    public VehicleMapperImpl(ObjectProvider<CompanyMapper> companyMapperProvider, ObjectProvider<AccountUserMapper> accountUserMapperProvider, ObjectProvider<UsageMapper> usageMapperProvider, CompanyRepository companyRepository) {
        this.companyMapperProvider = companyMapperProvider;
        this.accountUserMapperProvider = accountUserMapperProvider;
        this.usageMapperProvider = usageMapperProvider;
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
            companyMapperProvider.getObject().toDTO(vehicle.getCompany()),
            accountUserMapperProvider.getObject().toDTO(vehicle.getAccountUser()),
            usageMapperProvider.getObject().toDTOList(vehicle.getUsages())
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
