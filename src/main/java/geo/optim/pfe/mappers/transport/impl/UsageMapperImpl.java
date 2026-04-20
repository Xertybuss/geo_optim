package geo.optim.pfe.mappers.transport.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.ObjectProvider;

import geo.optim.pfe.dtos.readDtos.transport.UsageReadDto;
import geo.optim.pfe.dtos.writeUpdateDto.transport.UsageWriteDto;
import geo.optim.pfe.entities.transport.Usage;
import geo.optim.pfe.mappers.organization.inter.CollaboraterMapper;
import geo.optim.pfe.mappers.transport.inter.UsageMapper;
import geo.optim.pfe.mappers.transport.inter.VehicleMapper;

@Component
public class UsageMapperImpl implements UsageMapper {
    private final CollaboraterMapper collaboraterMapper;
    private final ObjectProvider<VehicleMapper> vehicleMapperProvider;

    public UsageMapperImpl(CollaboraterMapper collaboraterMapper, ObjectProvider<VehicleMapper> vehicleMapperProvider) {
        this.collaboraterMapper = collaboraterMapper;
        this.vehicleMapperProvider = vehicleMapperProvider;
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
            vehicleMapperProvider.getObject().toDTO(usage.getVehicle())
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
