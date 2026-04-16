package geo.optim.pfe.dtos.readDtos.organization;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.transport.TripReadDto;
import geo.optim.pfe.dtos.readDtos.transport.VehicleReadDto;
import geo.optim.pfe.dtos.readDtos.user.AccountUserReadDto;

public record CompanyReadDto(
    Integer id,
    String codeCompany,
    String label,
    String address,
    String phoneNumber,
    List<VehicleReadDto> vehicles,
    List<AccountUserReadDto> accounts,
    List<CollaboraterReadDto> collaboraters,
    List<TripReadDto> trips,
    List<ClientApplicationReadDto> clientApplications
) {}
