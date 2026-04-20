package geo.optim.pfe.controllers.transport;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.transport.TripReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.TripWriteDto;
import geo.optim.pfe.mappers.transport.inter.TripMapper;
import geo.optim.pfe.services.inter.transport.TripService;

@RestController
@RequestMapping("/trips")
public class TripController {
    private TripService tripService;
    private TripMapper tripMapper;

    public TripController(TripService tripService, TripMapper tripMapper){
        this.tripService = tripService;
        this.tripMapper = tripMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public List<TripReadDto> getAllTrips() {
        return tripMapper.toDTOList(tripService.getAllTrips());
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS') or hasAnyAuthority('DRIVER')")
    public TripReadDto getTripById(@PathVariable Integer id) {
        return tripMapper.toDTO(tripService.getTripById(id));
    }
    
    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public TripReadDto createTrip(@RequestBody TripWriteDto entity) {
        return tripMapper.toDTO(tripService.createTrip(tripMapper.toEntity(entity)));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public TripReadDto updateTrip(@RequestBody TripWriteDto entity) {
        return tripMapper.toDTO(tripService.updateTrip(tripMapper.toEntity(entity)));   
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public void deleteTrip(@PathVariable Integer id){
        tripService.deleteTrip(id);
    }
}
