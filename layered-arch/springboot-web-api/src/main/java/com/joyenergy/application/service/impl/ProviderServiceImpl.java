package com.joyenergy.application.service.impl;

import com.joyenergy.application.service.ProviderService;
import com.joyenergy.domain.Provider;
import com.joyenergy.domain.command.ProviderCreateCommand;
import com.joyenergy.domain.command.ProviderDeleteCommand;
import com.joyenergy.domain.command.ProviderUpdateCommand;
import com.joyenergy.application.repository.ProviderRepository;
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

