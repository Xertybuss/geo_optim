package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.transport.TripReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.TripWriteDto;
import geo.optim.pfe.entities.transport.Trip;
import geo.optim.pfe.mappers.organization.inter.CompanyMapper;
import geo.optim.pfe.mappers.transport.inter.ConstParameterMapper;
import geo.optim.pfe.mappers.transport.inter.TravelMapper;
import geo.optim.pfe.mappers.transport.inter.TripMapper;
import geo.optim.pfe.repositories.organization.CompanyRepository;

@Component
public class TripMapperImpl implements TripMapper {
    private final ObjectProvider<ConstParameterMapper> constParameterMapperProvider;
    private final TravelMapper travelMapper;
    private final ObjectProvider<CompanyMapper> companyMapperProvider;
    private final CompanyRepository companyRepository;

    public TripMapperImpl(ObjectProvider<ConstParameterMapper> constParameterMapperProvider, TravelMapper travelMapper, ObjectProvider<CompanyMapper> companyMapperProvider, CompanyRepository companyRepository) {
        this.constParameterMapperProvider = constParameterMapperProvider;
        this.travelMapper = travelMapper;
        this.companyMapperProvider = companyMapperProvider;
        this.companyRepository = companyRepository;
    }

    @Override
    public TripReadDto toDTO(Trip trip) {
        if (trip == null) {
            return null;
        }
        return new TripReadDto(
            trip.getId(),
            trip.getLabel(),
            trip.getDate_start(),
            trip.getDate_end(),
            trip.getStatus_generated(),
            trip.getTotal_distance(),
            trip.getTotal_duration(),
            trip.getTotal_passengers(),
            constParameterMapperProvider.getObject().toDTOList(trip.getParameters()),
            travelMapper.toDTOList(trip.getTravels()),
            companyMapperProvider.getObject().toDTO(trip.getCompany())
        );
    }

    @Override
    public Trip toEntity(TripWriteDto tripWriteDto) {
        if (tripWriteDto == null) {
            return null;
        }
        Trip trip = new Trip();
        trip.setLabel(tripWriteDto.getLabel());
        trip.setDate_start(tripWriteDto.getDate_start());
        trip.setDate_end(tripWriteDto.getDate_end());
        trip.setStatus_generated(tripWriteDto.getStatus_generated());
        trip.setTotal_distance(tripWriteDto.getTotal_distance());
        trip.setTotal_duration(tripWriteDto.getTotal_duration());
        trip.setTotal_passengers(tripWriteDto.getTotal_passengers());
        trip.setCompany(companyRepository.findById(tripWriteDto.getCompany_id()).orElse(null));
        return trip;
    }

    @Override
    public List<TripReadDto> toDTOList(List<Trip> trips) {
        if (trips == null) {
            return null;
        }
        return trips.stream()
                .map(this::toDTO)
                .toList();
    }

}
