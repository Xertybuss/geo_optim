package geo.optim.pfe.entities.user;

import java.util.List;

import geo.optim.pfe.entities.common.Dates;
import geo.optim.pfe.entities.transport.Vehicle;
import geo.optim.pfe.entities.organization.Company;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountUser extends Dates{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 20)
    private String phoneNumber;
    private boolean activated = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
    @OneToMany(mappedBy = "accountUser")
    private List<Vehicle> vehicles; 
}
