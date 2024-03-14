package com.rosendo.toDoList.domain.tasks.services;

import com.rosendo.toDoList.controllers.TaskControllers;
import com.rosendo.toDoList.domain.tasks.dtos.TaskRecordDto;
import com.rosendo.toDoList.domain.tasks.enums.ColumnsNames;
import com.rosendo.toDoList.domain.tasks.models.*;
import com.rosendo.toDoList.domain.tasks.repositories.*;
import com.rosendo.toDoList.exceptions.ResourceNotFoundException;

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

    @Autowired
    TaskRepositoryBacklog taskRepositoryBacklog;

    @Autowired
    TaskRepositoryInbox taskRepositoryInbox;

    @Autowired
    TaskRepositoryToDo taskRepositoryToDo;

    @Autowired
    TaskRepositoryDoing taskRepositoryDoing;

    @Autowired
    TaskRepositoryDone taskRepositoryDone;

    public TaskRecordDto getTaskById(Long id) {
        TaskRecordDto modelDto = new TaskRecordDto(null, null, null, null, null);

        if (taskRepositoryBacklog.existsById(id)){
            TaskModelBacklog task = taskRepositoryBacklog.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class).getAllTasks()).withRel("List of tasks"));
        }
        else if (taskRepositoryInbox.existsById(id)){
            TaskModelDone task = taskRepositoryDone.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class).getAllTasks()).withRel("List of tasks"));
        }
        else if (taskRepositoryToDo.existsById(id)){
            TaskModelToDo task = taskRepositoryToDo.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class).getAllTasks()).withRel("List of tasks"));
        }
        else if (taskRepositoryDoing.existsById(id)){
            TaskModelDoing task = taskRepositoryDoing.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class).getAllTasks()).withRel("List of tasks"));
        }
        else if (taskRepositoryDone.existsById(id)){
            TaskModelDone task = taskRepositoryDone.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class).getAllTasks()).withRel("List of tasks"));
        }

        return modelDto;
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
