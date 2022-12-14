package com.webarchlabs.store.application.repository;

import com.webarchlabs.store.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
