package com.rosendo.toDoList.domain.services;

import com.rosendo.toDoList.controllers.TaskControllers;
import com.rosendo.toDoList.domain.dtos.TaskRecordDto;
import com.rosendo.toDoList.exceptions.ResourceNotFoundException;
import com.rosendo.toDoList.domain.models.TaskModel;
import com.rosendo.toDoList.domain.repositories.TaskRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    @Autowired
    TaskRepository repository;

    public TaskModel getTaskById(Long id){
        TaskModel task = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found task!"));

        task.add(linkTo(methodOn(TaskControllers.class).getAllTasks()).withRel("List of tasks"));

        return task;
    }
    
    public List<TaskModel> getAllTasks(){
        List<TaskModel> listOfTasks = repository.findAll();
        for(TaskModel taskModel : listOfTasks){
            taskModel.add(linkTo(methodOn(TaskControllers.class).getTaskById(taskModel.getId())).withSelfRel());
        }
        return listOfTasks;
    }

    public TaskModel createTask(TaskRecordDto modelDto){
        var model = new TaskModel();
        BeanUtils.copyProperties(modelDto, model);

        model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getId())).withSelfRel());

        return repository.save(model);
    }

    public TaskModel updateTask(Long id, TaskRecordDto modelDto){

        TaskModel task = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found task!"));
        
        BeanUtils.copyProperties(modelDto, task);

        task.add(linkTo(methodOn(TaskControllers.class).getTaskById(task.getId())).withSelfRel());

        return repository.save(task);
    }
    
    public void deleteTask(Long id){

        TaskModel task = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found task!"));

        repository.delete(task);
    }

}
