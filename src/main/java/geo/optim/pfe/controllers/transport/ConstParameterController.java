package geo.optim.pfe.controllers.transport;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geo.optim.pfe.dtos.readDtos.transport.ConstParameterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.ConstParameterWriteDto;
import geo.optim.pfe.mappers.transport.inter.ConstParameterMapper;
import geo.optim.pfe.services.inter.transport.ConstParameterService;

@RestController
@RequestMapping("/const_parameters")
public class ConstParameterController {
    private ConstParameterService constParameterService;
    private ConstParameterMapper ConstParameterMapper;

    public ConstParameterController(ConstParameterService constParameterService, ConstParameterMapper ConstParameterMapper){
        this.constParameterService = constParameterService;
        this.ConstParameterMapper = ConstParameterMapper;

    }

    @GetMapping("/all")
    public List<ConstParameterReadDto> getAllConstParameters() {
        return ConstParameterMapper.toDTOList(constParameterService.getAllConstParameters());
    }
    
    @GetMapping("/get/{id}")
    public ConstParameterReadDto getConstParameterById(@PathVariable Integer id) {
        return ConstParameterMapper.toDTO(constParameterService.getConstParameterById(id));
    }
    
    @PostMapping("/create")
    public ConstParameterReadDto createConstParameter(@RequestBody ConstParameterWriteDto entity) {
        return ConstParameterMapper.toDTO(constParameterService.createConstParameter(ConstParameterMapper.toEntity(entity)));
    }

    @PostMapping("/update")
    public ConstParameterReadDto updateConstParameter(@RequestBody ConstParameterWriteDto entity) {
        return ConstParameterMapper.toDTO(constParameterService.updateConstParameter(ConstParameterMapper.toEntity(entity)));   
    }

    @DeleteMapping("/delete/{id}")
    public void deleteConstParameter(@PathVariable Integer id){
        constParameterService.deleteConstParameter(id);
    }
}
