package geo.optim.pfe.entities.organization;

import java.util.List;

import geo.optim.pfe.entities.common.Dates;
import geo.optim.pfe.entities.transport.Travel;
import geo.optim.pfe.entities.transport.Usage;
import geo.optim.pfe.enums.TypeCollab;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collaborater extends Dates{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 20)
    private String phoneNumber;
    @Column(nullable = false, length = 150)
    private String homeLocation;
    @Column(nullable = false, length = 200)
    private String address;
    @Enumerated(value = EnumType.STRING)
    private TypeCollab collabType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @OneToMany(mappedBy = "collaborater")
    private List<Usage> usages;
    @OneToMany(mappedBy = "collaborater")
    private List<Travel> travels;
}
