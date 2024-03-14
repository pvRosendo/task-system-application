package com.rosendo.toDoList.domain.tasks.services;

import com.rosendo.toDoList.controllers.TaskControllers;
import com.rosendo.toDoList.domain.tasks.dtos.GetTaskRecordDto;
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

import java.util.ArrayList;
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
        TaskRecordDto modelDto = new TaskRecordDto(
            null,
            null,
            null,
            null,
            null
        );

        if (taskRepositoryBacklog.existsById(id)){
            TaskModelBacklog task = taskRepositoryBacklog.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class)
                    .getAllTasks(new GetTaskRecordDto(ColumnsNames.backlog)))
                    .withRel("List of tasks"));
        }
        else if (taskRepositoryInbox.existsById(id)){
            TaskModelDone task = taskRepositoryDone.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class)
                    .getAllTasks(new GetTaskRecordDto(ColumnsNames.inbox)))
                    .withRel("List of tasks"));
        }
        else if (taskRepositoryToDo.existsById(id)){
            TaskModelToDo task = taskRepositoryToDo.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class)
                    .getAllTasks(new GetTaskRecordDto(ColumnsNames.toDo)))
                    .withRel("List of tasks"));
        }
        else if (taskRepositoryDoing.existsById(id)){
            TaskModelDoing task = taskRepositoryDoing.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class)
                    .getAllTasks(new GetTaskRecordDto(ColumnsNames.doing)))
                    .withRel("List of tasks"));
        }
        else if (taskRepositoryDone.existsById(id)){
            TaskModelDone task = taskRepositoryDone.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Not found!"));

            BeanUtils.copyProperties(task, modelDto);
            task.add(linkTo(methodOn(TaskControllers.class)
                    .getAllTasks(new GetTaskRecordDto(ColumnsNames.done)))
                    .withRel("List of tasks"));
        }

        return modelDto;
    }
    
    public List<TaskRecordDto> getAllTasks(GetTaskRecordDto modelDto) {

        List<TaskRecordDto> taskRecordDtoList = new ArrayList<>();

        if (modelDto.nameColumn() == ColumnsNames.backlog) {
            List<TaskModelBacklog> listOfTasks = taskRepositoryBacklog.findAll();
            for (TaskModelBacklog taskModel : listOfTasks) {
                taskModel.add(linkTo(methodOn(TaskControllers.class).getTaskById(taskModel.getId())).withSelfRel());
            }
            BeanUtils.copyProperties(listOfTasks, taskRecordDtoList);
        }
        else if (modelDto.nameColumn() == ColumnsNames.inbox) {
            List<TaskModelInbox> listOfTasks = taskRepositoryInbox.findAll();
            for (TaskModelInbox taskModel : listOfTasks) {
                BeanUtils.copyProperties(listOfTasks, taskRecordDtoList);
                taskModel.add(linkTo(methodOn(TaskControllers.class).getTaskById(taskModel.getId())).withSelfRel());
            }
            BeanUtils.copyProperties(listOfTasks, taskRecordDtoList);
        }
        else if (modelDto.nameColumn() == ColumnsNames.toDo) {
            List<TaskModelToDo> listOfTasks = taskRepositoryToDo.findAll();
            for (TaskModelToDo taskModel : listOfTasks) {
                taskModel.add(linkTo(methodOn(TaskControllers.class).getTaskById(taskModel.getId())).withSelfRel());
            }
            BeanUtils.copyProperties(listOfTasks, taskRecordDtoList);
        }
        else if (modelDto.nameColumn() == ColumnsNames.doing) {
            List<TaskModelDoing> listOfTasks = taskRepositoryDoing.findAll();
            for (TaskModelDoing taskModel : listOfTasks) {
                taskModel.add(linkTo(methodOn(TaskControllers.class).getTaskById(taskModel.getId())).withSelfRel());
            }
            BeanUtils.copyProperties(listOfTasks, taskRecordDtoList);
        }
        else if (modelDto.nameColumn() == ColumnsNames.done) {
            List<TaskModelDone> listOfTasks = taskRepositoryDone.findAll();
            for (TaskModelDone taskModel : listOfTasks) {
                taskModel.add(linkTo(methodOn(TaskControllers.class).getTaskById(taskModel.getId())).withSelfRel());
            }
            BeanUtils.copyProperties(listOfTasks, taskRecordDtoList);
        }

        return taskRecordDtoList;
    }

    public TaskRecordDto createTask(TaskRecordDto modelDto){
        if(modelDto.nameColumn() == ColumnsNames.backlog){
            var model = new TaskModelBacklog();
            BeanUtils.copyProperties(modelDto, model);
            model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getId())).withSelfRel());
            taskRepositoryBacklog.save(model);
        }
        else if(modelDto.nameColumn() == ColumnsNames.inbox){
            var model = new TaskModelInbox();
            BeanUtils.copyProperties(modelDto, model);
            model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getId())).withSelfRel());
            taskRepositoryInbox.save(model);
        }
        else if(modelDto.nameColumn() == ColumnsNames.toDo){
            var model = new TaskModelToDo();
            BeanUtils.copyProperties(modelDto, model);
            model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getId())).withSelfRel());
            taskRepositoryToDo.save(model);
        }
        else if(modelDto.nameColumn() == ColumnsNames.doing){
            var model = new TaskModelDoing();
            BeanUtils.copyProperties(modelDto, model);
            model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getId())).withSelfRel());
            taskRepositoryDoing.save(model);
        }
        else if(modelDto.nameColumn() == ColumnsNames.done){
            var model = new TaskModelDone();
            BeanUtils.copyProperties(modelDto, model);
            model.add(linkTo(methodOn(TaskControllers.class).getTaskById(model.getId())).withSelfRel());
            taskRepositoryDone.save(model);
        }

        return modelDto;
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
