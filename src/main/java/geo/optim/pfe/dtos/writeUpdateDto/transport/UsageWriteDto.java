package geo.optim.pfe.dtos.writeUpdateDto.transport;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsageWriteDto {
    private Date dateStart_affectation;
    private Date dateEnd_affectation;
    private Time startHourMourning;
    private Time endHourMourning;
    private Time startHourEvening;
    private Time endHourEvening;
    private int collaborater_id;
    private int vehicle_id;
}
