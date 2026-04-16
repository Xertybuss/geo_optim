package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.transport.ConstParameterReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.ConstParameterWriteDto;
import geo.optim.pfe.entities.transport.ConstParameter;
import geo.optim.pfe.mappers.transport.inter.ConstParameterMapper;
import geo.optim.pfe.mappers.transport.inter.TripMapper;
import geo.optim.pfe.repositories.transport.TripRepository;

public class ConstParameterMapperImpl implements ConstParameterMapper {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    public ConstParameterMapperImpl(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
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
            tripMapper.toDTO(constParameter.getTrip())
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
