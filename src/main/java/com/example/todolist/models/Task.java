package com.example.todolist.models;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotEmpty(message="Description cannot be empty!")
    @NotNull(message = "Description cannot be null")
    @Size(min=3, max = 50)
    private String description;
    private String status = "In progress";
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate timeCreated = LocalDate.now();



    public Task() {

    }

    public Task( String description) {
        this.description = description;
    }

    public Task(String description, String status, LocalDate timeCreated) {
        this.description = description;
        this.status = status;
        this.timeCreated = timeCreated;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDate timeCreated) {
        this.timeCreated = timeCreated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
