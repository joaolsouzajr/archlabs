package com.joyenergy.api.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProviderCreateCommandDto {

    @NotBlank
    private String title;
}
