package geo.optim.pfe.services.impl.organization;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.organization.Collaborater;
import geo.optim.pfe.repositories.organization.CollaboraterRepository;
import geo.optim.pfe.services.inter.organization.CollaboraterService;

@Service
public class CollaboraterServiceImpl implements CollaboraterService {
    private final CollaboraterRepository collaboraterRepository;
    
    public CollaboraterServiceImpl(CollaboraterRepository collaboraterRepository) {
        this.collaboraterRepository = collaboraterRepository;
    }

    @Override
    public List<Collaborater> getAllCollaboraters() {
        return collaboraterRepository.findAll();
    }

    @Override
    public Collaborater getCollaboraterById(Integer id) {
        return collaboraterRepository.findById(id).get();
    }

    @Override
    public Collaborater createCollaborater(Collaborater collaborater) {
        return collaboraterRepository.save(collaborater);
    }

    @Override
    public Collaborater updateCollaborater(Collaborater collaborater) {
        Collaborater existingCollaborater = collaboraterRepository.findById(collaborater.getId()).get();
        BeanUtils.copyProperties(collaborater, existingCollaborater, "id");
        return collaboraterRepository.save(existingCollaborater);
    }

    @Override
    public void deleteCollaborater(Integer id) {
        collaboraterRepository.deleteById(id);
    }
}
