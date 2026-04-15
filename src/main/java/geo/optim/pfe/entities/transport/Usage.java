package geo.optim.pfe.entities.transport;

import java.sql.Date;
import java.sql.Time;

import geo.optim.pfe.entities.organization.Collaborater;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usage{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateStartAffectation;
    private Date dateEndAffectation;
    private Time startHourMorning;
    private Time endHourMorning;
    private Time startHourEvening;
    private Time endHourEvening;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborater_id", nullable = false)
    private Collaborater collaborater;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
}
