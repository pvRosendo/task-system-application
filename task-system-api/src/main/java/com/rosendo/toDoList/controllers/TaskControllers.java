package com.rosendo.toDoList.controllers;

import java.util.List;

import com.rosendo.toDoList.domain.tasks.dtos.GetTaskRecordDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rosendo.toDoList.domain.tasks.dtos.TaskRecordDto;
import com.rosendo.toDoList.domain.tasks.services.TaskServices;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/tasks")
public class TaskControllers {

  @Autowired
  TaskServices services;

  
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Finds task by id", description = "Finds task by id", tags = {"Tasks"},
          responses = {
                  @ApiResponse(description="Success", responseCode = "200", content = {@Content(mediaType = "application/json")}),
                  @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                  @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                  @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                  @ApiResponse(description="Internal Error", responseCode="500", content=@Content),
          }
  )
  public ResponseEntity<Object> getTaskById(@PathVariable(value = "id") Long id){
    return ResponseEntity.status(HttpStatus.OK).body(services.getTaskById(id));
  }
  
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Finds all Tasks", description = "Finds all Tasks", tags = {"Tasks"},
          responses = {
                  @ApiResponse(description = "Success", responseCode = "200",
                          content = {
                                  @Content(
                                          mediaType = "application/json",
                                          array = @ArraySchema(schema = @Schema(implementation = TaskRecordDto.class)))
                          }),
                  @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                  @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                  @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                  @ApiResponse(description="Internal Error", responseCode="500", content=@Content),
          }
  )
  public ResponseEntity<List<TaskRecordDto>> getAllTasks(@RequestBody @Valid GetTaskRecordDto recordsDto){
    return ResponseEntity.status(HttpStatus.OK).body(services.getAllTasks(recordsDto));
  }
  
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create a new task", description = "Create a new task", tags = {"Tasks"},
          responses = {
                  @ApiResponse(description="Success", responseCode = "200", content = {@Content(mediaType = "application/json")}),
                  @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                  @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                  @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                  @ApiResponse(description="Internal Error", responseCode="500", content=@Content),
          }
  )
  public ResponseEntity<TaskRecordDto> createTask(@RequestBody @Valid TaskRecordDto recordsDto){
    return ResponseEntity.status(HttpStatus.CREATED).body(services.createTask(recordsDto));
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Update a new task", description = "Update a new task", tags = {"Tasks"},
          responses = {
                  @ApiResponse(description="Success", responseCode = "200", content = {@Content(mediaType = "application/json")}),
                  @ApiResponse(description="Bad Request", responseCode="400", content=@Content),
                  @ApiResponse(description="Unauthorized", responseCode="401", content=@Content),
                  @ApiResponse(description="Not Found", responseCode="404", content=@Content),
                  @ApiResponse(description="Internal Error", responseCode="500", content=@Content),
          }
  )
  public ResponseEntity<TaskRecordDto> updateTask(@PathVariable(value="id") Long id, @RequestBody @Valid TaskRecordDto recordsDto){
    return ResponseEntity.status(HttpStatus.OK).body(services.updateTask(id, recordsDto));
  }

  @DeleteMapping(value = "/{id}")
  @Operation(summary = "Deletes a task", description = "Deletes a task!", tags = {"Tasks"},
          responses = {
                  @ApiResponse(description="No Content", responseCode = "204", content = @Content),
                  @ApiResponse(description="Bad Request", responseCode = "400", content = @Content),
                  @ApiResponse(description="Unauthorized", responseCode = "401", content = @Content),
                  @ApiResponse(description="Not Found", responseCode = "404", content = @Content),
                  @ApiResponse(description="Internal Error", responseCode = "500", content = @Content),
          }
  )
  public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long id){
    services.deleteTask(id);
    return ResponseEntity.noContent().build();
  }
}
