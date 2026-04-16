package geo.optim.pfe.services.impl.transport;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import geo.optim.pfe.entities.transport.ConstParameter;
import geo.optim.pfe.repositories.transport.ConstParameterRepository;
import geo.optim.pfe.services.inter.transport.ConstParameterService;

@Service
public class ConstParameterServiceImpl implements ConstParameterService {
    private final ConstParameterRepository constParameterRepository;
    
    public ConstParameterServiceImpl(ConstParameterRepository constParameterRepository) {
        this.constParameterRepository = constParameterRepository;
    }

    @Override
    public ConstParameter getConstParameterById(Integer id) {
        return constParameterRepository.findById(id).get();
    }

    @Override
    public List<ConstParameter> getAllConstParameters() {
        return constParameterRepository.findAll();
    }

    @Override
    public ConstParameter createConstParameter(ConstParameter constParameter) {
        return constParameterRepository.save(constParameter);
    }

    @Override
    public ConstParameter updateConstParameter(ConstParameter constParameter) {
        ConstParameter existingConstParameter = constParameterRepository.findById(constParameter.getId()).get();
        BeanUtils.copyProperties(constParameter, existingConstParameter, "id");
        return constParameterRepository.save(existingConstParameter);
    }

    @Override
    public void deleteConstParameter(Integer id) {
        constParameterRepository.deleteById(id);
    }    
}
