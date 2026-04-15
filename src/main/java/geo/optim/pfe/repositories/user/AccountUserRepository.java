package geo.optim.pfe.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import geo.optim.pfe.entities.user.AccountUser;

public interface AccountUserRepository extends JpaRepository<AccountUser, Integer> {

}
