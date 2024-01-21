package com.rosendo.toDoList.dtos;

import jakarta.validation.constraints.NotBlank;

public record TaskRecordDto(@NotBlank String nameTask, @NotBlank String description) {}
