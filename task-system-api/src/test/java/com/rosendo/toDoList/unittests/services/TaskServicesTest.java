package com.rosendo.toDoList.unittests.services;

import com.rosendo.toDoList.domain.tasks.dtos.TaskRecordDto;
import com.rosendo.toDoList.unittests.mocks.MockTasks;
import com.rosendo.toDoList.domain.tasks.models.TaskModel;
import com.rosendo.toDoList.domain.tasks.repositories.TaskRepository;
import com.rosendo.toDoList.domain.tasks.services.TaskServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TaskServicesTest {

    MockTasks input;

    @InjectMocks
    private TaskServices taskServices;

    @Mock
    private TaskRepository taskRepository;


    @BeforeEach
    void setUp() throws Exception {
        input = new MockTasks();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTaskById() throws Exception {
        TaskModel task = input.mockTask(1);
        task.setId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        var result = taskServices.getTaskById(1L);
        assertNotNull(result);
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/tasks>;rel=\"List of tasks\"]"));

        assertEquals("Name Test1", result.getNameTask());
        assertEquals("Description Test1", result.getDescription());
        assertTrue(result.getPriority() >= 1 && result.getPriority() <= 5);
        assertEquals("Status Test1", result.getStatus());
        assertEquals(1L, result.getId());
    }

    @Test
    void getAllTasks() throws Exception {
        List<TaskModel> listOfTasks = input.mockListTasks();

        when(taskRepository.findAll()).thenReturn(listOfTasks);

        var result = taskServices.getAllTasks();
        for(int i = 0; i<listOfTasks.size(); i++){

            assertEquals("Name Test" + i, result.get(i).getNameTask());
            assertEquals("Description Test" + i, result.get(i).getDescription());
            assertTrue(result.get(i).getPriority() >= 1 && result.get(i).getPriority() <= 5);
            assertEquals("Status Test" + i, result.get(i).getStatus());
            assertEquals(((long) i), result.get(i).getId());
            assertNotNull(result.get(i).getLinks());
            assertTrue(result.toString().contains("</api/tasks/" + i + ">;rel=\"self\"" ));

        }
            assertNotNull(result);
    }

    @Test
    void createTask() throws Exception{
        TaskRecordDto taskRecordDto = input.mockTaskDto(1);
        TaskModel task = input.mockTask(1);
        TaskModel taskPersisted = new TaskModel();

        taskPersisted.setId(1L);
        taskPersisted.setNameTask(taskRecordDto.nameTask());
        taskPersisted.setDescription(taskRecordDto.description());
        taskPersisted.setPriority(taskRecordDto.priority());
        taskPersisted.setStatus(taskRecordDto.status());

        when(taskRepository.save(Mockito.any())).thenReturn(taskPersisted);

        var result = taskServices.createTask(taskRecordDto);

        assertNotNull(result);
        assertNotNull(result.getLinks());

        assertEquals("Name Test1", result.getNameTask());
        assertEquals("Description Test1", result.getDescription());
        assertTrue(result.getPriority() >= 1 && result.getPriority() <= 5);
        assertEquals("Status Test1", result.getStatus());
        assertEquals(1L, result.getId());
    }

    @Test
    void updateTask() throws Exception {
        TaskModel task = input.mockTask(1);

        TaskRecordDto taskRecordDto = input.mockTaskDto(1);

        TaskModel taskPersisted = new TaskModel();

        taskPersisted.setId(1L);
        taskPersisted.setNameTask(taskRecordDto.nameTask());
        taskPersisted.setDescription(taskRecordDto.description());
        taskPersisted.setPriority(taskRecordDto.priority());
        taskPersisted.setStatus(taskRecordDto.status());

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(taskPersisted);

        var result = taskServices.updateTask(1L, taskRecordDto);

        assertNotNull(result);
        assertNotNull(result.getLinks());

        assertEquals("Name Test1", result.getNameTask());
        assertEquals("Description Test1", result.getDescription());
        assertTrue(result.getPriority() >= 1 && result.getPriority() <= 5);
        assertEquals("Status Test1", result.getStatus());
        assertEquals(1L, result.getId());
    }


    @Test
    void deleteTask() throws Exception {
        TaskModel task = input.mockTask(1);
        task.setId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskServices.deleteTask(1L);

    }
}