package com.webarchlabs.store.domain.command;


import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Value
@Builder
public class ProviderDeleteCommand {
    @NotNull
    UUID id;
}
