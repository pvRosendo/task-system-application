package com.rosendo.toDoList.domain.tasks.repositories;

import com.rosendo.toDoList.domain.tasks.models.TaskModelDoing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepositoryDoing extends JpaRepository<TaskModelDoing, UUID> {}
