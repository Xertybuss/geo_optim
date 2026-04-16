package geo.optim.pfe.services.inter.user;

import java.util.List;

import geo.optim.pfe.entities.user.Permission;

public interface PermissionService {
    public List<Permission> getAllPermissions();
    public Permission getPermissionById(Integer id);
    public Permission createPermission(Permission permission);
    public Permission updatePermission(Permission permission);
    public void deletePermission(Integer id);
}
