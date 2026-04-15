package geo.optim.pfe.dtos.readDtos.organization;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.transport.TravelReadDto;
import geo.optim.pfe.dtos.readDtos.transport.UsageReadDto;

public record CollaboraterReadDto(
    int id,
    String firstName,
    String lastName,
    String phoneNumber,
    String homeLocation,
    String address,
    String collabType,
    CompanyReadDto company,
    List<UsageReadDto> usages,
    List<TravelReadDto> travels
) {}
