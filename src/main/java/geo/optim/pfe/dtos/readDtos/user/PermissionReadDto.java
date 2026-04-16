package geo.optim.pfe.dtos.readDtos.user;

public record PermissionReadDto(
    Integer id,
    String codePermission,
    String label,
    ProfileReadDto profile
) {}
