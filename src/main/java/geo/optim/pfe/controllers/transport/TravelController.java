package geo.optim.pfe.controllers.transport;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.transport.TravelReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.TravelWriteDto;
import geo.optim.pfe.mappers.transport.inter.TravelMapper;
import geo.optim.pfe.services.inter.transport.TravelService;

@RestController
@RequestMapping("/travels")
public class TravelController {
    private TravelService travelService;
    private TravelMapper travelMapper;

    public TravelController(TravelService travelService, TravelMapper travelMapper) {
        this.travelService = travelService;
        this.travelMapper = travelMapper;
    }

    @GetMapping("/all")
    public List<TravelReadDto> getAllTravels() {
        return travelMapper.toDTOList(travelService.getAllTravels());
    }
    
    @GetMapping("/get/{id}")
    public TravelReadDto getTravelById(@PathVariable Integer id) {
        return travelMapper.toDTO(travelService.getTravelById(id));
    }
    
    @PostMapping("/create")
    public TravelReadDto createTravel(@RequestBody TravelWriteDto entity) {
        return travelMapper.toDTO(travelService.createTravel(travelMapper.toEntity(entity)));
    }

    @PostMapping("/update")
    public TravelReadDto updateTravel(@RequestBody TravelWriteDto entity) {
        return travelMapper.toDTO(travelService.updateTravel(travelMapper.toEntity(entity)));   
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTravel(@PathVariable Integer id){
        travelService.deleteTravel(id);
    }
}