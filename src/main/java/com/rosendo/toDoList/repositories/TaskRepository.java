package com.rosendo.toDoList.repositories;

import com.rosendo.toDoList.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {}
