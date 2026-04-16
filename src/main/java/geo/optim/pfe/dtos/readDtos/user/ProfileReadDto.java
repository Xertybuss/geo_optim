package geo.optim.pfe.dtos.readDtos.user;

import java.util.List;

public record ProfileReadDto(
    Integer id,
    String codeProfile,
    String label,
    List<AccountUserReadDto> accounts,
    List<PermissionReadDto> permissions
) {}
