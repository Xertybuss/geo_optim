package geo.optim.pfe.entities.transport;

import java.util.List;

import geo.optim.pfe.entities.common.Dates;
import geo.optim.pfe.entities.organization.Company;
import geo.optim.pfe.entities.user.AccountUser;
import geo.optim.pfe.enums.TypeVehicle;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends Dates{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 20)
    private String imei;
    @Column(nullable = false, unique = true, length = 15)
    private String immatriculation;
    @Column(nullable = true, length = 100)
    private String label;
    @Enumerated(value = EnumType.STRING)
    private TypeVehicle vehicleType;
    @Column(nullable = false)
    private int capacityPlaces;
    @Column(nullable = false, scale = 2)
    private double capacityWeight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_user_id")
    private AccountUser accountUser;
    @OneToMany(mappedBy = "vehicle")
    private List<Usage> usages;
}
