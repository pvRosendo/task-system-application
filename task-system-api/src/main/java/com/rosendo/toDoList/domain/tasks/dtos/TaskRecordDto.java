package com.rosendo.toDoList.domain.tasks.dtos;

import com.rosendo.toDoList.domain.tasks.enums.ColumnsNames;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRecordDto(
        @NotBlank String nameTask,
        @NotBlank String description,
        @NotNull Integer priority,
        @NotBlank String status,
        @NotBlank ColumnsNames nameColumn
) {}