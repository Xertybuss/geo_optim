package geo.optim.pfe.services.inter.transport;

import java.util.List;

import geo.optim.pfe.entities.transport.Trip;

public interface TripService {
    public Trip getTripById(Integer id);
    public List<Trip> getAllTrips();
    public Trip createTrip(Trip trip);
    public Trip updateTrip(Trip trip);
    public void deleteTrip(Integer id);
}