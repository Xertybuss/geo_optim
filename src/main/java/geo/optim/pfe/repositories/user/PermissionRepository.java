package geo.optim.pfe.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import geo.optim.pfe.entities.user.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
