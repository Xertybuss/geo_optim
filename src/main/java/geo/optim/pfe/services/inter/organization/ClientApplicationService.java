package geo.optim.pfe.services.inter.organization;

import java.util.List;

import geo.optim.pfe.entities.organization.ClientApplication;

public interface ClientApplicationService {
    public ClientApplication getClientApplicationById(Integer id);
    public List<ClientApplication> getAllClientApplications();
    public ClientApplication createClientApplication(ClientApplication clientApplication);
    public ClientApplication updateClientApplication(ClientApplication clientApplication);
    public void deleteClientApplication(Integer id);
}