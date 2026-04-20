package geo.optim.pfe.controllers.organization;

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

import geo.optim.pfe.dtos.readDtos.organization.CollaboraterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.CollaboraterWriteDto;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.services.inter.organization.CollaboraterService;

@RestController
@RequestMapping("/collaboraters")
public class CollaboraterController {
    private CollaboraterService collaboraterService;
    private CollaboraterMapper collaboraterMapper;

    public CollaboraterController(CollaboraterService collaboraterService, CollaboraterMapper collaboraterMapper) {
        this.collaboraterService = collaboraterService;
        this.collaboraterMapper = collaboraterMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public List<CollaboraterReadDto> getAllCollaboraters() {
        return collaboraterMapper.toDTOList(collaboraterService.getAllCollaboraters());
        
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public CollaboraterReadDto getCollaboraterById(@PathVariable Integer id) {
        return collaboraterMapper.toDTO(collaboraterService.getCollaboraterById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public ResponseEntity<CollaboraterReadDto> postMethodName(@RequestBody CollaboraterWriteDto entity) {
        return ResponseEntity.ok(collaboraterMapper.toDTO(collaboraterService.createCollaborater(collaboraterMapper.toEntity(entity))));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public CollaboraterReadDto updateCollaborater(@RequestBody CollaboraterWriteDto entity) {       
        return collaboraterMapper.toDTO(collaboraterService.updateCollaborater(collaboraterMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public void deleteCollaborater(@PathVariable Integer id) {
        collaboraterService.deleteCollaborater(id);
    }
}
