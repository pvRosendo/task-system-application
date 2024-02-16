package com.rosendo.toDoList.unittests.mocks;

import com.rosendo.toDoList.dtos.TaskRecordDto;
import com.rosendo.toDoList.models.TaskModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockTasks {

    public TaskModel mockTask() throws Exception {
        return mockTask(0);
    }

    public TaskRecordDto mockTaskDto() throws Exception {
        return mockTaskDto(0);
    }

    public List<TaskModel> mockListTasks() throws Exception {

        List<TaskModel> listOfTasks = new ArrayList<TaskModel>();

        for(int i = 0; i<14; i++){
          listOfTasks.add(mockTask(i));
        }
        return listOfTasks;
    }


    public TaskModel mockTask(Integer number) throws Exception {
        TaskModel task = new TaskModel();
        Random rand = new Random();

        task.setId(number.longValue());
        task.setNameTask("Name Test" + number);
        task.setDescription("Description Test" + number);
        task.setPriority(rand.nextInt(5)+1);
        task.setStatus("Status Test" + number);

        return task;
    }

    public TaskRecordDto mockTaskDto(Integer number) throws Exception {
        Random rand = new Random();

        return new TaskRecordDto(
                "Name Test"+ number,
                "Description Test" + number,
                rand.nextInt(5)+1,
                "Status Test" + number
        );
    }
}