package geo.optim.pfe.entities.transport;

import geo.optim.pfe.entities.organization.Collaborater;
import geo.optim.pfe.entities.user.AccountUser;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    private AccountUser created_by;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by_id")
    private AccountUser updated_by;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
    @ManyToOne(fetch = FetchType.LAZY)
    private Collaborater collaborater;
}
