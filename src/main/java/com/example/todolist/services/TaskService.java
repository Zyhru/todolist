package com.example.todolist.services;

import com.example.todolist.models.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void createTask(Task task) {

        taskRepository.save(task);
    }


    public List<Task> getAllTask() {
        return (List<Task>) taskRepository.findAll();
    }



//    public Task getTaskById(Integer id) {
//        Optional<Task> optionalTask = taskRepository.findById(id);
//        Task task = null;
//
//        if(optionalTask.isPresent()) {
//            task = optionalTask.get();
//        } else {
//            throw new RuntimeException("Task not found for id: " + id);
//        }
//
//
//
//        return task;
//
//    }

    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Integer id) {


        taskRepository.deleteById(id);

        // Delete the task
        // Decrement the task by 1 and set it


    }

    public void update(Task task) {

        taskRepository.save(task);

    }








}
