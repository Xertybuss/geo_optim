package geo.optim.pfe.controllers.organization;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.organization.ClientApplicationReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.organization.ClientApplicationWriteDto;
import geo.optim.pfe.mappers.organization.inter.ClientApplicationMapper;
import geo.optim.pfe.services.inter.organization.ClientApplicationService;

@RestController
@RequestMapping("/client_applications")
public class ClientApplicationController {
    private ClientApplicationService clientApplicationService;
    private ClientApplicationMapper clientApplicationMapper;

    public ClientApplicationController(ClientApplicationService clientApplicationService, ClientApplicationMapper clientApplicationMapper) {
        this.clientApplicationService = clientApplicationService;
        this.clientApplicationMapper = clientApplicationMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<ClientApplicationReadDto> getAllClientApplications() {
        return clientApplicationMapper.toDTOList(clientApplicationService.getAllClientApplications());
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ClientApplicationReadDto getClientApplicationById(@PathVariable Integer id) {
        return clientApplicationMapper.toDTO(clientApplicationService.getClientApplicationById(id));
    }
    
    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ClientApplicationReadDto createClientApplication(@RequestBody ClientApplicationWriteDto entity) {
        return clientApplicationMapper.toDTO(clientApplicationService.createClientApplication(clientApplicationMapper.toEntity(entity)));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ClientApplicationReadDto updateClientApplication(@RequestBody ClientApplicationWriteDto entity) {
        return clientApplicationMapper.toDTO(clientApplicationService.updateClientApplication(clientApplicationMapper.toEntity(entity)));   
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteClientApplication(@PathVariable Integer id){
        clientApplicationService.deleteClientApplication(id);
    }
}