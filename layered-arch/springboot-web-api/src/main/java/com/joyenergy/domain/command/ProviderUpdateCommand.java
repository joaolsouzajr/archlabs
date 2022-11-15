package com.joyenergy.domain.command;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Value
@Builder
public class ProviderUpdateCommand {

    @NotNull
    UUID id;

    @NotBlank
    String title;
}
