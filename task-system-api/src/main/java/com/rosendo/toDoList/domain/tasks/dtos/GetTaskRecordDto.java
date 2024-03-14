package com.rosendo.toDoList.domain.tasks.dtos;

import com.rosendo.toDoList.domain.tasks.enums.ColumnsNames;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GetTaskRecordDto(
        @NotBlank ColumnsNames nameColumn
) {}