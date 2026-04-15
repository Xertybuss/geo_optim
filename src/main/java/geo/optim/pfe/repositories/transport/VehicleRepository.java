package geo.optim.pfe.repositories.transport;

import org.springframework.data.jpa.repository.JpaRepository;

import geo.optim.pfe.entities.transport.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
