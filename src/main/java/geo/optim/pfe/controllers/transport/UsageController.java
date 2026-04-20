package geo.optim.pfe.controllers.transport;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.transport.UsageReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.UsageWriteDto;
import geo.optim.pfe.mappers.transport.inter.UsageMapper;
import geo.optim.pfe.services.inter.transport.UsageService;

@RestController
@RequestMapping("/usages")
public class UsageController {
    private UsageService usageService;
    private UsageMapper UsageMapper;

    public UsageController(UsageService usageService, UsageMapper UsageMapper) {
        this.usageService = usageService;
        this.UsageMapper = UsageMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public List<UsageReadDto> getAllUsages() {
        return UsageMapper.toDTOList(usageService.getAllUsages());
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS') or hasAnyAuthority('DRIVER')")
    public UsageReadDto getReadDto(@PathVariable Integer id) {
        return UsageMapper.toDTO(usageService.getUsageById(id));
    }
    
    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public UsageReadDto createUsage(@RequestBody UsageWriteDto entity) {
        return UsageMapper.toDTO(usageService.createUsage(UsageMapper.toEntity(entity)));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public UsageReadDto updateUsage(@RequestBody UsageWriteDto entity) {
        return UsageMapper.toDTO(usageService.updateUsage(UsageMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('LOGISTICS')")
    public void deleteUsage(@PathVariable Integer id){
        usageService.deleteUsage(id);
    }
}