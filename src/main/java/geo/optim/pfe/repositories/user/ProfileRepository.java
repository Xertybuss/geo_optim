package geo.optim.pfe.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import geo.optim.pfe.entities.user.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
