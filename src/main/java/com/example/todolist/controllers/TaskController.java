package com.example.todolist.controllers;


import com.example.todolist.models.Task;
import com.example.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private final String redirectTaskPage = "redirect:/tasks/getAll";




    // adds a task to our database by performing a POST request, then it redirects us to all of our tasks (localhost:8080/tasks/getAll
    @PostMapping("/addTask")
    public String createTask(@ModelAttribute("task") @Valid Task task, BindingResult result, Model model) {

        // if task is empty, prompt error message to the user
        if(result.hasErrors()) {
            model.addAttribute("task",task);
            System.out.println("Description size is less than 2!");
            return redirectTaskPage;
        } else {
            System.out.println("Adding task: " + task.toString());
            taskService.createTask(task);
        }

        return redirectTaskPage;
    }


    // returns localhost:8080/tasks/getAll
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


    // Deleting a task
    @GetMapping("/deleteTask")
    public String deleteTask(Integer id) {

        taskService.deleteTask(id);

        return redirectTaskPage;
    }

    // /update endpoint performs a POST to update a task
    @PostMapping("/update")
    public String update(Task task) {

        taskService.update(task);
        return redirectTaskPage;

    }


    /*
        Grabbing the id of a row
        Checking to see if the status is equal to "In Progress"
        If so then change the status to "Complete" and vice-versa
     */
    @PostMapping("/status/{id}")
    public String updateStatus(@PathVariable("id") Integer id, Model model) {

        Task task = taskService.getTaskById(id).orElseThrow();

        if("In progress".equals(task.getStatus())) {
            task.setStatus("Complete");
        } else {
            task.setStatus("In progress");
        }

        taskService.update(task);


        return redirectTaskPage;

    }











}
