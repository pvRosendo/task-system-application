package com.rosendo.toDoList.services;

import com.rosendo.toDoList.controllers.TaskControllers;
import com.rosendo.toDoList.dtos.TaskRecordDto;
import com.rosendo.toDoList.models.TaskModel;
import com.rosendo.toDoList.repositories.TaskRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {

    @Autowired
    TaskRepository repository;

    public Optional<TaskModel> getTaskById(Long id){
        Optional<TaskModel> taskModel = repository.findById(id);

        taskModel.get().add(linkTo(methodOn(TaskControllers.class).getAllTasks()).withRel("List of tasks"));

        return taskModel;
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

        model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getKey())).withSelfRel());
        return repository.save(model);
    }

    public TaskModel updateTask(Long id, TaskRecordDto modelDto){

        Optional<TaskModel> task = repository.findById(id);

        if(task.isEmpty()){} //TODO adicionar a exceção
        
        var model = task.get();
        
        BeanUtils.copyProperties(modelDto, model);

        model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getKey())).withSelfRel());

        return repository.save(model);
    }
    
    public void deleteTask(Long id){

        Optional<TaskModel> task = repository.findById(id);

        if(task.isEmpty()){} //TODO adicionar a exceção

        repository.delete(task.get());
    }

}
