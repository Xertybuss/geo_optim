package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import geo.optim.pfe.dtos.readDtos.transport.TravelReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.TravelWriteDto;
import geo.optim.pfe.entities.transport.Travel;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.mappers.transport.inter.TravelMapper;
import geo.optim.pfe.repositories.organization.CollaboraterRepository;
import geo.optim.pfe.repositories.transport.TripRepository;
import geo.optim.pfe.repositories.user.AccountUserRepository;

@Component
public class TravelMapperImpl implements TravelMapper {
    private final CollaboraterMapper collaboraterMapper;
    private final AccountUserRepository accountUserRepository;
    private final TripRepository tripRepository;
    private final CollaboraterRepository collaboraterRepository;

    public TravelMapperImpl(CollaboraterMapper collaboraterMapper, AccountUserRepository accountUserRepository, TripRepository tripRepository, CollaboraterRepository collaboraterRepository) {
        this.collaboraterMapper = collaboraterMapper;
        this.accountUserRepository = accountUserRepository;
        this.tripRepository = tripRepository;
        this.collaboraterRepository = collaboraterRepository;
    }

    @Override
    public TravelReadDto toDTO(Travel travel) {
        if (travel == null) {
            return null;
        }
        return new TravelReadDto(
            travel.getId(),
            null,
            null,
            null,
            collaboraterMapper.toDTO(travel.getCollaborater())
        );
    }

    @Override
    public Travel toEntity(TravelWriteDto travelDto) {
        if (travelDto == null) {
            return null;
        }
        Travel travel = new Travel();
        travel.setCreated_by(accountUserRepository.findById(travelDto.getCreated_by()).orElse(null));
        travel.setUpdated_by(accountUserRepository.findById(travelDto.getUpdated_by()).orElse(null));
        travel.setTrip(tripRepository.findById(travelDto.getTrip_id()).orElse(null));
        travel.setCollaborater(collaboraterRepository.findById(travelDto.getCollaborater_id()).orElse(null));
        return travel;
    }

    @Override
    public List<TravelReadDto> toDTOList(List<Travel> travels) {
        if (travels == null) {
            return null;
        }
        return travels.stream()
                .map(this::toDTO)
                .toList();
    }
}
