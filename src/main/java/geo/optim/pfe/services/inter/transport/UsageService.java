package geo.optim.pfe.services.inter.transport;

import java.util.List;

import geo.optim.pfe.entities.transport.Usage;

public interface UsageService {
    public List<Usage> getAllUsages();
    public Usage getUsageById(Integer id);
    public Usage createUsage(Usage usage);
    public Usage updateUsage(Usage usage);
    public void deleteUsage(Integer id);
}