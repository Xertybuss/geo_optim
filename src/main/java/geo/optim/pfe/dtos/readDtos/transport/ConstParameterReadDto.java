package geo.optim.pfe.dtos.readDtos.transport;

public record ConstParameterReadDto(
    Integer id,
    String code_param,
    String value_param,
    TripReadDto trip
) {}
