package geo.optim.pfe.services.inter.user;

import java.util.List;

import geo.optim.pfe.entities.user.Profile;

public interface ProfileService {
    public List<Profile> getAllProfiles();
    public Profile getProfileById(Integer id);
    public Profile createProfile(Profile profile);
    public Profile updateProfile(Profile profile);
    public void deleteProfile(Integer id);
}
