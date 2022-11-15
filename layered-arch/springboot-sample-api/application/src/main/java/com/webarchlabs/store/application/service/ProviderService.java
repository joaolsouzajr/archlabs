package com.webarchlabs.store.application.service;

import com.webarchlabs.store.domain.Provider;
import com.webarchlabs.store.domain.command.ProviderCreateCommand;
import com.webarchlabs.store.domain.command.ProviderDeleteCommand;
import com.webarchlabs.store.domain.command.ProviderUpdateCommand;

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

