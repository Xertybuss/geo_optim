package geo.optim.pfe.dtos.readDtos.transport;

import geo.optim.pfe.dtos.readDtos.organization.CollaboraterReadDto;
import geo.optim.pfe.dtos.readDtos.user.AccountUserReadDto;

public record TravelReadDto(
    Integer id,
    AccountUserReadDto created_by,
    AccountUserReadDto updated_by,
    TripReadDto trip,
    CollaboraterReadDto collaborater
) {}
