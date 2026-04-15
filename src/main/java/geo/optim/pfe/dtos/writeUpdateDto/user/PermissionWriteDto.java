package geo.optim.pfe.dtos.writeUpdateDto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PermissionWriteDto {
    private String codePermission;
    private String label;
    private int profileId;
}
