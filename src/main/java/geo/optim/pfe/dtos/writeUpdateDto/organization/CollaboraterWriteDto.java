package geo.optim.pfe.dtos.writeUpdateDto.organization;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CollaboraterWriteDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeLocation;
    private String address;
    private String collabType;
    private int company_id;
}
