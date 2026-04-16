package geo.optim.pfe.services.impl.user;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.user.Profile;
import geo.optim.pfe.repositories.user.ProfileRepository;
import geo.optim.pfe.services.inter.user.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(Integer id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Profile existingProfile = profileRepository.findById(profile.getId()).get();
        BeanUtils.copyProperties(profile, existingProfile, "id");
        return profileRepository.save(existingProfile);
    }

    @Override
    public void deleteProfile(Integer id) {
        profileRepository.deleteById(id);
    }
}
