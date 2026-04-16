package geo.optim.pfe.services.inter.organization;

import java.util.List;

import geo.optim.pfe.entities.organization.Collaborater;

public interface CollaboraterService {
    List<Collaborater> getAllCollaboraters();
    Collaborater getCollaboraterById(Integer id);
    Collaborater createCollaborater(Collaborater collaborater);
    Collaborater updateCollaborater(Collaborater collaborater);
    void deleteCollaborater(Integer id);
}
