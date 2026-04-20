package geo.optim.pfe.controllers.organization;

import java.util.List;

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
    public List<ClientApplicationReadDto> getAllClientApplications() {
        return clientApplicationMapper.toDTOList(clientApplicationService.getAllClientApplications());
    }
    
    @GetMapping("/get/{id}")
    public ClientApplicationReadDto getClientApplicationById(@PathVariable Integer id) {
        return clientApplicationMapper.toDTO(clientApplicationService.getClientApplicationById(id));
    }
    
    @PostMapping("/create")
    public ClientApplicationReadDto createClientApplication(@RequestBody ClientApplicationWriteDto entity) {
        return clientApplicationMapper.toDTO(clientApplicationService.createClientApplication(clientApplicationMapper.toEntity(entity)));
    }

    @PostMapping("/update")
    public ClientApplicationReadDto updateClientApplication(@RequestBody ClientApplicationWriteDto entity) {
        return clientApplicationMapper.toDTO(clientApplicationService.updateClientApplication(clientApplicationMapper.toEntity(entity)));   
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClientApplication(@PathVariable Integer id){
        clientApplicationService.deleteClientApplication(id);
    }
}