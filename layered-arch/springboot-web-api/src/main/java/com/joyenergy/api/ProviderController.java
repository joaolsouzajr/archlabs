package com.joyenergy.api;

import com.joyenergy.api.dto.ProviderCreateCommandDto;
import com.joyenergy.api.dto.ProviderUpdateCommandDto;
import com.joyenergy.api.dto.ProviderDto;
import com.joyenergy.application.service.ProviderService;
import com.joyenergy.domain.command.ProviderDeleteCommand;
import com.joyenergy.infraestructure.api.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v0/api/providers")
@AllArgsConstructor
@Slf4j
public class ProviderController {

    private final ProviderService providerService;
    private final LibraryApiMapper mapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProviderDto>>> getAll() {
        log.info("List all books");
        var response = new ApiResponse<List<ProviderDto>>();
        response.setData(mapper.providerListToProviderDtoList(providerService.findAllProviders()));
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ProviderDto> getProvider(@PathVariable UUID id) {
        return providerService.findProviderById(id)
                .map(provider -> ResponseEntity.ok(mapper.providerToProviderDto(provider)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProviderDto>> save(@RequestBody ProviderCreateCommandDto dto) {
        var provider = providerService.save(mapper.providerCreateCommandDtoToProviderCreateCommand(dto));
        var response = new ApiResponse<ProviderDto>();
        response.setData(mapper.providerToProviderDto(provider));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody ProviderUpdateCommandDto dto) {
        var responseEntity = ResponseEntity.notFound().build();

        if (providerService.existsById(id)) {
            var provider = providerService.update(mapper.prividerUpdateCommandDtoToProviderUpdateCommand(dto));
            responseEntity = ResponseEntity.ok(mapper.providerToProviderDto(provider));
        }

        return responseEntity;
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        var responseEntity = ResponseEntity.notFound().build();

        if (providerService.existsById(id)) {
            providerService.delete(ProviderDeleteCommand.builder().id(id).build());
            responseEntity = ResponseEntity.ok().build();
        }

        return responseEntity;
    }


}
