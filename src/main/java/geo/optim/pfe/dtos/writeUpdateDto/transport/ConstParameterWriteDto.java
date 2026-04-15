package geo.optim.pfe.dtos.writeUpdateDto.transport;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConstParameterWriteDto {
    private String code_param;
    private String value_param;
    private int trip_id;
}
