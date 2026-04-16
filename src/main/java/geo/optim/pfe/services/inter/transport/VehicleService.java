package geo.optim.pfe.services.inter.transport;

import java.util.List;

import geo.optim.pfe.entities.transport.Vehicle;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Integer id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(Integer id);
}
