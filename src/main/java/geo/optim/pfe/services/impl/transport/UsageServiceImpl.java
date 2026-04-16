package geo.optim.pfe.services.impl.transport;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.transport.Usage;
import geo.optim.pfe.repositories.transport.UsageRepository;
import geo.optim.pfe.services.inter.transport.UsageService;

@Service
public class UsageServiceImpl implements UsageService {
    private final UsageRepository usageRepository;

    public UsageServiceImpl(UsageRepository usageRepository) {
        this.usageRepository = usageRepository;
    }

    @Override
    public Usage getUsageById(Integer id) {
        return usageRepository.findById(id).get();
    }

    @Override
    public List<Usage> getAllUsages() {
        return usageRepository.findAll();
    }

    @Override
    public Usage createUsage(Usage usage) {
        return usageRepository.save(usage);
    }

    @Override
    public Usage updateUsage(Usage usage) {
        Usage existingUsage = usageRepository.findById(usage.getId()).get();
        BeanUtils.copyProperties(existingUsage, usage, "id");
        return usageRepository.save(existingUsage);
    }

    @Override
    public void deleteUsage(Integer id) {
        usageRepository.deleteById(id);
    }
}