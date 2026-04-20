package geo.optim.pfe.controllers.transport;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.transport.VehicleReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.VehicleWriteDto;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;
import geo.optim.pfe.services.inter.transport.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private VehicleService vehicleService;
    private VehicleMapper vehicleMapper;

    public VehicleController(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public List<VehicleReadDto> getAllVehicles() {
        return vehicleMapper.toDTOList(vehicleService.getAllVehicles());
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public VehicleReadDto getVehicleById(@PathVariable Integer id) {
        return vehicleMapper.toDTO(vehicleService.getVehicleById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public ResponseEntity<VehicleReadDto> postMethodName(@RequestBody VehicleWriteDto entity) {
        return ResponseEntity.ok(vehicleMapper.toDTO(vehicleService.createVehicle(vehicleMapper.toEntity(entity))));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public VehicleReadDto updateVehicle(@RequestBody VehicleWriteDto entity) {       
        return vehicleMapper.toDTO(vehicleService.updateVehicle(vehicleMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public void deleteVehicle(@PathVariable Integer id) {
        vehicleService.deleteVehicle(id);
    }
}
