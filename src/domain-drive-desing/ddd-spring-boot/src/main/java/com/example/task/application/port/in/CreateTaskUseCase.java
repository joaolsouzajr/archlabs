package com.example.task.application.port.in;

import com.example.task.domain.Task;

import java.util.UUID;

public interface SaveTaskUseCase {

    Task save(CreateTaskCommand command);

    Task update(UpdateTaskCommand command);

    void delete(UUID id);

    Task findById(UUID id);
}
