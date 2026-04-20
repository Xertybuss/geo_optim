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

import geo.optim.pfe.dtos.readDtos.user.ProfileReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.user.ProfileWriteDto;
import geo.optim.pfe.mappers.user.ProfileMapper;
import geo.optim.pfe.services.inter.user.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private ProfileService profileService;
    private ProfileMapper profileMapper;

    public ProfileController(ProfileService profileService, ProfileMapper profileMapper){
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<ProfileReadDto> getAllProfiles() {
        return profileMapper.toDTOList(profileService.getAllProfiles());
    }
    
    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ProfileReadDto getProfileById(@PathVariable Integer id) {
        return profileMapper.toDTO(profileService.getProfileById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ProfileReadDto createProfile(@RequestBody ProfileWriteDto entity) {
        return profileMapper.toDTO(profileService.createProfile(profileMapper.toEntity(entity)));
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ProfileReadDto updateProfile(@RequestBody ProfileWriteDto entity) {
        return profileMapper.toDTO(profileService.updateProfile(profileMapper.toEntity(entity)));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteProfile(@PathVariable Integer id){
        profileService.deleteProfile(id);
    }
}
