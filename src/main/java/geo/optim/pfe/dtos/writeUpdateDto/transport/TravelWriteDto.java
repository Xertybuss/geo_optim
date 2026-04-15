package geo.optim.pfe.dtos.writeUpdateDto.transport;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TravelWriteDto {
    private Integer created_by;
    private Integer updated_by;
    private Integer trip_id;
    private Integer collaborater_id;
}