package geo.optim.pfe.dtos.readDtos.organization;

import java.sql.Date;

public record ClientApplicationReadDto(
    Integer id,
    String code_app,
    String label,
    String api_key,
    Date max_transaction_day,
    Boolean activated,
    CompanyReadDto company
) {}
