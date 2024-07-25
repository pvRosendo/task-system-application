package com.rosendo.toDoList.domain.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_TASKS")
public class TaskModel extends RepresentationModel<TaskModel> implements Serializable{

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameTask;
    private String description;
    private Integer priority;
    private String status;

    public TaskModel() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) throws Exception{
        try{
            this.priority = priority;

        }catch(Exception e){
            throw new Exception("Only permissive add priority in interval of 1 to 5");
        }

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TaskModel taskModel = (TaskModel) o;

        if (!Objects.equals(id, taskModel.id)) return false;
        if (!Objects.equals(nameTask, taskModel.nameTask)) return false;
        if (!Objects.equals(description, taskModel.description))
            return false;
        if (!Objects.equals(priority, taskModel.priority)) return false;
        return Objects.equals(status, taskModel.status);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nameTask != null ? nameTask.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
