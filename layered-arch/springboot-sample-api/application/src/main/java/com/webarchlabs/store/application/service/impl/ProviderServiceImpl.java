package com.webarchlabs.store.application.service.impl;

import com.webarchlabs.store.application.repository.ProviderRepository;
import com.webarchlabs.store.application.service.ProviderService;
import com.webarchlabs.store.domain.Provider;
import com.webarchlabs.store.domain.command.ProviderCreateCommand;
import com.webarchlabs.store.domain.command.ProviderDeleteCommand;
import com.webarchlabs.store.domain.command.ProviderUpdateCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository repository;

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<Provider> findProviderById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Provider> findAllProviders() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Provider save(ProviderCreateCommand bookCreateCommand) {
        var provider= repository.save(Provider.create(bookCreateCommand));
        return provider;
    }

    @Override
    @Transactional
    public Provider update(ProviderUpdateCommand providerUpdateCommand) {
        var provider = repository.findById(providerUpdateCommand.getId());

        provider.ifPresentOrElse((value) -> value.update(providerUpdateCommand),
                () -> {
                    throw new RuntimeException();
                });

        var providerUpdated = repository.save(provider.get());

        return providerUpdated;
    }

    @Override
    @Transactional
    public void delete(ProviderDeleteCommand bookDeleteCommand) {
        var book = repository.findById(bookDeleteCommand.getId());
        book.ifPresentOrElse(repository::delete, () -> {
            throw new RuntimeException();
        });
    }
}

