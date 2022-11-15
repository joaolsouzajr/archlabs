package com.joyenergy.api;

import com.joyenergy.api.dto.ProviderCreateCommandDto;
import com.joyenergy.api.dto.ProviderDeleteCommandDto;
import com.joyenergy.api.dto.ProviderDto;
import com.joyenergy.api.dto.ProviderUpdateCommandDto;
import com.joyenergy.domain.Provider;
import com.joyenergy.domain.command.ProviderCreateCommand;
import com.joyenergy.domain.command.ProviderDeleteCommand;
import com.joyenergy.domain.command.ProviderUpdateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LibraryApiMapper {

    ProviderCreateCommand providerCreateCommandDtoToProviderCreateCommand(ProviderCreateCommandDto dto);

    ProviderUpdateCommand prividerUpdateCommandDtoToProviderUpdateCommand(ProviderUpdateCommandDto dto);

    ProviderDeleteCommand providerDeleteCommandDtoToProviderDeleteCommand(ProviderDeleteCommandDto dto);

    ProviderDto providerToProviderDto(Provider provider);

    List<ProviderDto> providerListToProviderDtoList(List<Provider> providers);

}
