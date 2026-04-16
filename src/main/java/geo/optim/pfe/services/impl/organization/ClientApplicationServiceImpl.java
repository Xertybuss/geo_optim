package geo.optim.pfe.services.impl.organization;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.organization.ClientApplication;
import geo.optim.pfe.repositories.organization.ClientApplicationRepository;
import geo.optim.pfe.services.inter.organization.ClientApplicationService;

@Service
public class ClientApplicationServiceImpl implements ClientApplicationService {
    private final ClientApplicationRepository clientApplicationRepository;

    public ClientApplicationServiceImpl(ClientApplicationRepository clientApplicationRepository) {
        this.clientApplicationRepository = clientApplicationRepository;
    }

    @Override
    public ClientApplication getClientApplicationById(Integer id) {
        return clientApplicationRepository.findById(id).get();
    }

    @Override
    public List<ClientApplication> getAllClientApplications() {
        return clientApplicationRepository.findAll();
    }

    @Override
    public ClientApplication createClientApplication(ClientApplication clientApplication) {
        return clientApplicationRepository.save(clientApplication);
    }

    @Override
    public ClientApplication updateClientApplication(ClientApplication clientApplication) {
        ClientApplication existingClientApplication = clientApplicationRepository.findById(clientApplication.getId()).get();
        BeanUtils.copyProperties(clientApplication, existingClientApplication, "id");
        return clientApplicationRepository.save(existingClientApplication);
    }

    @Override
    public void deleteClientApplication(Integer id) {
        clientApplicationRepository.deleteById(id);
    }
}
