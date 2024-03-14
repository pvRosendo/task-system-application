package com.rosendo.toDoList.domain.tasks.repositories;


import com.rosendo.toDoList.domain.tasks.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {}
