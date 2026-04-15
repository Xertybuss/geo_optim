package geo.optim.pfe.dtos.readDtos.transport;

import java.sql.Date;
import java.util.List;

import geo.optim.pfe.dtos.readDtos.organization.CompanyReadDto;

public record TripReadDto(
    Integer id,
    String label,
    Date date_start,
    Date date_end,
    Boolean status_generated,
    double total_distance,
    int total_duration,
    int total_passengers,
    List<ConstParameterReadDto> parameters,
    List<TravelReadDto> travels,
    CompanyReadDto company
) {}
