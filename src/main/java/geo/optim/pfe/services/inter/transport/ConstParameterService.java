package geo.optim.pfe.services.inter.transport;

import java.util.List;

import geo.optim.pfe.entities.transport.ConstParameter;

public interface ConstParameterService {
    public ConstParameter getConstParameterById(Integer id);
    public List<ConstParameter> getAllConstParameters();
    public ConstParameter createConstParameter(ConstParameter constParameter);
    public ConstParameter updateConstParameter(ConstParameter constParameter);
    public void deleteConstParameter(Integer id);
}
