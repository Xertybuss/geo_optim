package geo.optim.pfe.services.impl.user;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.user.Permission;
import geo.optim.pfe.repositories.user.PermissionRepository;
import geo.optim.pfe.services.inter.user.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermissionById(Integer id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission updatePermission(Permission permission) {
        Permission existingPermission = permissionRepository.findById(permission.getId()).get();
        BeanUtils.copyProperties(permission, existingPermission, "id");
        return permissionRepository.save(existingPermission);
    }

    @Override
    public void deletePermission(Integer id) {
        permissionRepository.deleteById(id);
    }

    
}
