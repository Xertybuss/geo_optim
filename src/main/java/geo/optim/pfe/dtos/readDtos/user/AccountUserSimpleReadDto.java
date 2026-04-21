package geo.optim.pfe.dtos.readDtos.user;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;

public record AccountUserSimpleReadDto(
    Integer id,
    String firstName,
    String lastName,
    String username,
    String phoneNumber,
    boolean activated,
    CompanyReadDto company
) {}
