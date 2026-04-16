package geo.optim.pfe.services.inter.transport;

import java.util.List;

import geo.optim.pfe.entities.transport.Travel;

public interface TravelService {
    public Travel getTravelById(Integer id);
    public List<Travel> getAllTravels();
    public Travel createTravel(Travel travel);
    public Travel updateTravel (Travel travel);
    public void deleteTravel(Integer id);
}
