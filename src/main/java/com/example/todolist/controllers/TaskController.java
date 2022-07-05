package com.example.todolist.controllers;


import com.example.todolist.models.Task;
import com.example.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private final String redirectTaskPage = "redirect:/tasks/getAll";



    /*
    Adds a task to taskdb
    then redirects to localhost:8080/tasks/getAll
     */
    @PostMapping("/addTask")
    public String createTask(@ModelAttribute("task") Task task) {
        Task t = new Task(task.getDescription());
        taskService.createTask(t);
        return redirectTaskPage;
    }


    // returns tasks.html
    @GetMapping("/getAll")
    public String getAllTask(Model model) {
        List<Task> tasks = taskService.getAllTask();

        // we are sending this data to the view
        // so the list of the tasks to the view
        // adding a new task will be sent to the view
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());

        taskService.getAllTask();
        return "tasks";
    }



    @RequestMapping("/getOne") // endpoint -> localhost:8080/tasks/getOne
    @ResponseBody // returns as an object
    public Optional<Task> getTaskById(Integer id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/deleteTask")
    public String deleteTask(Integer id) {

        taskService.deleteTask(id);

        return redirectTaskPage;
    }


    @PostMapping("/update")
    public String update(Task task) {

        taskService.update(task);
        return redirectTaskPage;

    }







}
