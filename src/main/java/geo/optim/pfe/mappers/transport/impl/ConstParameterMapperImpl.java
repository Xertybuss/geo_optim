package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.transport.ConstParameterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.ConstParameterWriteDto;
import geo.optim.pfe.entities.transport.ConstParameter;
import geo.optim.pfe.mappers.transport.inter.ConstParameterMapper;
import geo.optim.pfe.mappers.transport.inter.TripMapper;
import geo.optim.pfe.repositories.transport.TripRepository;

@Component
public class ConstParameterMapperImpl implements ConstParameterMapper {
    private final TripRepository tripRepository;
    private final ObjectProvider<TripMapper> tripMapperProvider;

    public ConstParameterMapperImpl(TripRepository tripRepository, ObjectProvider<TripMapper> tripMapperProvider) {
        this.tripRepository = tripRepository;
        this.tripMapperProvider = tripMapperProvider;
    }

    @Override
    public ConstParameterReadDto toDTO(ConstParameter constParameter) {
        if (constParameter == null) {
            return null;
        }
        return new ConstParameterReadDto(
            constParameter.getId(),
            constParameter.getCode_param(),
            constParameter.getValue_param(),
            tripMapperProvider.getObject().toDTO(constParameter.getTrip())
        );
    }

    @Override
    public ConstParameter toEntity(ConstParameterWriteDto constParameterDto) {
        if (constParameterDto == null) {
            return null;
        }
        ConstParameter constParameter = new ConstParameter();
        constParameter.setCode_param(constParameterDto.getCode_param());
        constParameter.setValue_param(constParameterDto.getValue_param());
        constParameter.setTrip(tripRepository.findById(constParameterDto.getTrip_id()).orElse(null));
        return constParameter;
    }

    @Override
    public List<ConstParameterReadDto> toDTOList(List<ConstParameter> constParameters) {
        if (constParameters == null) {
            return null;
        }
        return constParameters.stream()
                .map(this::toDTO)
                .toList();
    }
}
