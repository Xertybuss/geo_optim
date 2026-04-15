package geo.optim.pfe.dtos.readDtos.transport;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;
import geo.optim.pfe.dtos.readDtos.user.AccountUserReadDto;

public record VehicleReadDto(
    int id,
    String imei,
    String immatriculation,
    String label,
    String vehicleType,
    int capacityPlaces,
    double capacityWeight,
    CompanyReadDto company,
    AccountUserReadDto accountUser,
    List<UsageReadDto> usages
) {}
