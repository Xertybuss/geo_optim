package geo.optim.pfe.entities.user;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import geo.optim.pfe.entities.common.Dates;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class Profile extends Dates{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 30)
    private String codeProfile;
    @Column(nullable = true, length = 100)
    private String label;
    @OneToMany(mappedBy = "profile")
    private List<AccountUser> accounts;
    @OneToMany(mappedBy = "profile")
    private List<Permission> permissions;
}
