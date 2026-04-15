package geo.optim.pfe.repositories.transport;

import org.springframework.data.jpa.repository.JpaRepository;

import geo.optim.pfe.entities.transport.Usage;

public interface UsageRepository extends JpaRepository<Usage, Integer> {

}
