package geo.optim.pfe.dtos.readDtos.user;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;
import geo.optim.pfe.dtos.readDtos.transport.VehicleReadDto;

public record AccountUserReadDto(
    int id,
    String firstName,
    String lastName,
    String username,
    String phoneNumber,
    boolean activated,
    CompanyReadDto company,
    ProfileReadDto profile,
    List<VehicleReadDto> vehicles
) {}