package com.rosendo.toDoList.domain.tasks.models;

import com.rosendo.toDoList.domain.tasks.enums.ColumnsNames;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_BACKLOG")
public class TaskModelBacklog extends RepresentationModel<TaskModelBacklog> implements Serializable{

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameTask;
    private String description;
    private Integer priority;
    private ColumnsNames status;

    public TaskModelBacklog() {};

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

    public ColumnsNames getStatus() {
        return status;
    }

    public void setStatus(ColumnsNames status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TaskModelBacklog that = (TaskModelBacklog) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(nameTask, that.nameTask)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(priority, that.priority)) return false;
        return Objects.equals(status, that.status);
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
