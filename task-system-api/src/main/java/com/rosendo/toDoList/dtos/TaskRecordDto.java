package com.rosendo.toDoList.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRecordDto(
        Long Id,
        @NotBlank String nameTask,
        @NotBlank String description,
        @NotNull Integer priority,
        @NotBlank String status) {}