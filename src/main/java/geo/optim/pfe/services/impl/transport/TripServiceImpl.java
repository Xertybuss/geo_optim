package geo.optim.pfe.services.impl.transport;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.transport.Trip;
import geo.optim.pfe.repositories.transport.TripRepository;
import geo.optim.pfe.services.inter.transport.TripService;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip getTripById(Integer id) {
        return tripRepository.findById(id).get();
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip updateTrip(Trip trip) {
        Trip existingTrip = tripRepository.findById(trip.getId()).get();
        BeanUtils.copyProperties(trip, existingTrip, "id");
        return tripRepository.save(existingTrip);
    }

    @Override
    public void deleteTrip(Integer id) {
        tripRepository.deleteById(id);
    }

    
}
