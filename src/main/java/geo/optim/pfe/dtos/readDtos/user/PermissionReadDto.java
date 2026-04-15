package geo.optim.pfe.dtos.readDtos.user;

public record PermissionReadDto(
    int id,
    String codePermission,
    String label,
    ProfileReadDto profile
) {}
