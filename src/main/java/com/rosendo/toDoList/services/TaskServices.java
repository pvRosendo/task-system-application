package com.rosendo.toDoList.services;

import com.rosendo.toDoList.dtos.TaskRecordDto;
import com.rosendo.toDoList.models.TaskModel;
import com.rosendo.toDoList.repositories.TaskRepository;

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
        return repository.findById(id);
    }
    
    public List<TaskModel> getAllTasks(){
        return repository.findAll();
    }

    public TaskModel createTask(TaskRecordDto modelDto){
        var model = new TaskModel();
        BeanUtils.copyProperties(modelDto, model);

        return repository.save(model);
    }

    public TaskModel updateTask(Long id, TaskRecordDto modelDto){

        Optional<TaskModel> task = repository.findById(id);

        if(task.isEmpty()){} //TODO adicionar a exceção
        
        var model = task.get();
        
        BeanUtils.copyProperties(modelDto, model);

        return repository.save(model);
    }
    
    public void deleteTask(Long id){

        Optional<TaskModel> task = repository.findById(id);

        if(task.isEmpty()){} //TODO adicionar a exceção

        repository.delete(task.get());
    }

}
