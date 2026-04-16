package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import geo.optim.pfe.dtos.readDtos.transport.UsageReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.UsageWriteDto;
import geo.optim.pfe.entities.transport.Usage;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.mappers.transport.inter.UsageMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;

public class UsageMapperImpl implements UsageMapper {
    private final CollaboraterMapper collaboraterMapper;
    private final VehicleMapper vehicleMapper;

    public UsageMapperImpl(CollaboraterMapper collaboraterMapper, VehicleMapper vehicleMapper) {
        this.collaboraterMapper = collaboraterMapper;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public UsageReadDto toDTO(Usage usage) {
        if (usage == null) {
            return null;
        }
        return new UsageReadDto(
            usage.getId(),
            usage.getDateStartAffectation(),
            usage.getDateEndAffectation(),
            usage.getStartHourMorning(),
            usage.getEndHourMorning(),
            usage.getStartHourEvening(),
            usage.getEndHourEvening(),
            collaboraterMapper.toDTO(usage.getCollaborater()),
            vehicleMapper.toDTO(usage.getVehicle())
        );
    }

    @Override
    public Usage toEntity(UsageWriteDto usageWriteDto) {
        if (usageWriteDto == null) {
            return null;
        }
        Usage usage = new Usage();
        usage.setDateStartAffectation(usageWriteDto.getDateStartAffectation());
        usage.setDateEndAffectation(usageWriteDto.getDateEndAffectation());
        usage.setStartHourMorning(usageWriteDto.getStartHourMorning());
        usage.setEndHourMorning(usageWriteDto.getEndHourMorning());
        usage.setStartHourEvening(usageWriteDto.getStartHourEvening());
        usage.setEndHourEvening(usageWriteDto.getEndHourEvening());
        return usage;
    }

    @Override
    public List<UsageReadDto> toDTOList(List<Usage> usages) {
        if (usages == null) {
            return null;
        }
        return usages.stream()
            .map(this::toDTO)
            .toList();
    }

}
