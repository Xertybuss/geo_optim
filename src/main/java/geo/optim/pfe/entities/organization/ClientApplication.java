package geo.optim.pfe.entities.organization;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  
    @Column(nullable = false, unique = true) 
    private String code_app;
    @Column(nullable = true, length = 100)
    private String label;
    @Column(nullable = false)
    private String api_key;
    @Column(nullable = false)
    private String secret;
    @Column(nullable = false)
    private Date max_transaction_day;
    private Boolean activated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
