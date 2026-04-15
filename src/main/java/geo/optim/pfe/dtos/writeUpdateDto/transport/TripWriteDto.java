package geo.optim.pfe.dtos.writeUpdateDto.transport;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TripWriteDto {
    private String label;
    private Date date_start;
    private Date date_end;
    private Boolean status_generated;
    private double total_distance;
    private int total_duration;
    private int total_passengers;
    private int company_id;
}