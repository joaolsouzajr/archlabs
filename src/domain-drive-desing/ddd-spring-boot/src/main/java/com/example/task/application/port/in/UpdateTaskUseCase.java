package com.example.task.application.port.in;

import com.example.task.domain.Task;

import java.util.UUID;

public interface DeleteTaskUseCase {

    void delete(UUID id);

}
