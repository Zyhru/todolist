package com.example.todolist;
import org.springframework.stereotype.Controller;



@Controller("/home")
public class HomeController {
    public String home() {
        return "index";
    }
}
