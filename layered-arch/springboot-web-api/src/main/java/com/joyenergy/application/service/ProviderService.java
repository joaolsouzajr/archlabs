package com.joyenergy.application.service;

import com.joyenergy.domain.Provider;
import com.joyenergy.domain.command.ProviderCreateCommand;
import com.joyenergy.domain.command.ProviderDeleteCommand;
import com.joyenergy.domain.command.ProviderUpdateCommand;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProviderService {

    boolean existsById(UUID id);

    Optional<Provider> findProviderById(UUID id);

    List<Provider> findAllProviders();

    Provider save(ProviderCreateCommand createCommand);

    Provider update(ProviderUpdateCommand updateCommand);

    void delete(ProviderDeleteCommand deleteCommand);

}

