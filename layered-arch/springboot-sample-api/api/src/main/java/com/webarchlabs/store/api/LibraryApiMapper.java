package com.webarchlabs.store.api;

import com.webarchlabs.store.api.dto.ProviderCreateCommandDto;
import com.webarchlabs.store.api.dto.ProviderDeleteCommandDto;
import com.webarchlabs.store.api.dto.ProviderDto;
import com.webarchlabs.store.api.dto.ProviderUpdateCommandDto;
import com.webarchlabs.store.domain.Provider;
import com.webarchlabs.store.domain.command.ProviderCreateCommand;
import com.webarchlabs.store.domain.command.ProviderDeleteCommand;
import com.webarchlabs.store.domain.command.ProviderUpdateCommand;
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
