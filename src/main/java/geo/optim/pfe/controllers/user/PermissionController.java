package geo.optim.pfe.controllers.user;

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

import geo.optim.pfe.dtos.readDtos.user.PermissionReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.PermissionWriteDto;
import geo.optim.pfe.mappers.user.PermissionMapper;
import geo.optim.pfe.services.inter.user.PermissionService;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private PermissionService permissionService;
    private PermissionMapper permissionMapper;

    public PermissionController(PermissionService permissionService, PermissionMapper permissionMapper){
        this.permissionService = permissionService;
        this.permissionMapper = permissionMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<PermissionReadDto> getAllPermissions() {
        return permissionMapper.toDTOList(permissionService.getAllPermissions());
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PermissionReadDto getPermission(@PathVariable Integer id) {
        return permissionMapper.toDTO(permissionService.getPermissionById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PermissionReadDto createPermission(@RequestBody PermissionWriteDto entity) {
        return permissionMapper.toDTO(permissionService.createPermission(permissionMapper.toEntity(entity)));
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PermissionReadDto updatePermission(@RequestBody PermissionWriteDto entity) {
        return permissionMapper.toDTO(permissionService.updatePermission(permissionMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deletePermission(@PathVariable Integer id){
        permissionService.deletePermission(id);
    }
}

