package geo.optim.pfe.services.impl.transport;

import java.util.List;

import org.springframework.beans.BeanUtils;

import geo.optim.pfe.entities.transport.Vehicle;
import geo.optim.pfe.repositories.transport.VehicleRepository;
import geo.optim.pfe.services.inter.transport.VehicleService;

public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicle.getId()).get();
        BeanUtils.copyProperties(existingVehicle, vehicle, "id");
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
