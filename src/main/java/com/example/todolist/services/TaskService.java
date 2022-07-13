package com.example.todolist.services;

import com.example.todolist.models.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private SortState sortState = SortState.DEFAUlT;

    public enum SortState {
        DEFAUlT,
        DESCRIPTION,
        TIME_CREATED,
        STATUS;
    }

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void createTask(Task task) {

        taskRepository.save(task);
    }


    public List<Task> getAllTask() {

        List<Task> taskList = (List<Task>) taskRepository.findAll();
        List<Task> unSortedList = null;

        switch(sortState) {

            case DESCRIPTION:
                taskList.sort(Comparator.comparing(Task::getDescription));
                break;
            case STATUS:
                taskList.sort(Comparator.comparing(Task::getStatus));
                break;
            case TIME_CREATED:
                taskList.sort(Comparator.comparing(Task::getTimeCreated));
                break;
            case DEFAUlT:
                unSortedList = taskList;
                break;
        }

        return taskList;

    }


    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Integer id) {


        taskRepository.deleteById(id);


    }

    public void update(Task task) {

        taskRepository.save(task);

    }


    // clicking on sort button will sort button by description

    public void sortTasks() {


        // Later I will implement the other sort options.

        sortState = SortState.DESCRIPTION;

        System.out.println("Sort State: " + sortState);

    }








}
