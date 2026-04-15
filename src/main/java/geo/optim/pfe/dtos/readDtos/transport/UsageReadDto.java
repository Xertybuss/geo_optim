package geo.optim.pfe.dtos.readDtos.transport;

import java.sql.Date;
import java.sql.Time;

import geo.optim.pfe.dtos.readDtos.organization.CollaboraterReadDto;

public record UsageReadDto(
    int id,
    Date dateStartAffectation,
    Date dateEndAffectation,
    Time startHourMorning,
    Time endHourMorning,
    Time startHourEvening,
    Time endHourEvening,
    CollaboraterReadDto collaborater,
    VehicleReadDto vehicle
) {}
