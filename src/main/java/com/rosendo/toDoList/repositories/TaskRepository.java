package com.rosendo.toDoList.repositories;

import com.rosendo.toDoList.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID> {}
