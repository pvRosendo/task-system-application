package com.rosendo.toDoList.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rosendo.toDoList.dtos.TaskRecordDto;
import com.rosendo.toDoList.models.TaskModel;
import com.rosendo.toDoList.services.TaskServices;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//TODO adicionar content negotiation

@RestController
@RequestMapping("/api/tasks")
public class TaskControllers {

  @Autowired
  TaskServices services;

  
  @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getTaskById(@PathVariable(value = "id") UUID id){
    
    return ResponseEntity.status(HttpStatus.OK).body(services.getTaskById(id));
  
  }
  
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TaskModel>> getAllTasks(){
    
    return ResponseEntity.status(HttpStatus.OK).body(services.getAllTasks());
  
  }
  
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TaskModel> createTask(@RequestBody @Valid TaskRecordDto recordsDto){

    return ResponseEntity.status(HttpStatus.CREATED).body(services.createTask(recordsDto));

  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TaskModel> updateTask(@PathVariable(value="id") UUID id, @RequestBody @Valid TaskRecordDto recordsDto){
    return ResponseEntity.status(HttpStatus.OK).body(services.updateTask(id, recordsDto));
  }

  @DeleteMapping()
  public ResponseEntity<?> deleteTask(@PathVariable(value = "id") UUID id){
    services.deleteTask(id);

    return ResponseEntity.noContent().build();
  }

}
