package geo.optim.pfe.repositories.transport;

import org.springframework.data.jpa.repository.JpaRepository;

import geo.optim.pfe.entities.transport.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
