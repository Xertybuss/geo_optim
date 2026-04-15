package geo.optim.pfe.dtos.writeUpdateDto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountUserWriteDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String typeCollab;
    private int companyId;
    private int profileId;
}
