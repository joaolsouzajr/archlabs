package com.webarchlabs.store.domain.command;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
@Builder
public class ProviderCreateCommand {

    @NotBlank
    String title;
}
