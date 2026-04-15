package geo.optim.pfe.dtos.writeUpdateDto.transport;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VehicleWriteDto {
    private String imei;
    private String immatriculation;
    private String label;
    private String vehicleType;
    private int capacityPlaces;
    private double capacityWeight;
    private int company_id;
}
