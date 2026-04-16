package geo.optim.pfe.services.impl.transport;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.transport.Travel;
import geo.optim.pfe.repositories.transport.TravelRepository;
import geo.optim.pfe.services.inter.transport.TravelService;

@Service
public class TravelServiceImpl implements TravelService {
    private final TravelRepository travelRepository;

    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public Travel getTravelById(Integer id) {
        return travelRepository.findById(id).get();
    }

    @Override
    public List<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    @Override
    public Travel createTravel(Travel travel) {
        return travelRepository.save(travel);
    }

    @Override
    public Travel updateTravel(Travel travel) {
        Travel existingTravel = travelRepository.findById(travel.getId()).get();
        BeanUtils.copyProperties(existingTravel, travel, "id");
        return travelRepository.save(existingTravel);
    }

    @Override
    public void deleteTravel(Integer id) {
        travelRepository.deleteById(id);
    }  
}
