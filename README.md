# todolist

## Purpose

The main purpose of this project is to get familiar with Spring Boot and enhance my skills on the backend and frontend.

## Planning

## To Do List
+ Add a task 
+ Delete a task 
+ Edit a task
+ Mark task done


### Add a task
* "+" will represent to add a task or "Add" (button) <br>
* When a task is added then task has the option to edit or delete


### Delete a task

+ "-" is used to represent to delete a task
+ You can only delete a task when its added

### Edit a task
+ To edit a task the user has to type over task

### Mark task complete
+ A checkmark will be used to represent the completion of the task
+ This checkmark will be shown once a task is added 
+ Checkmark will be greyed out and have option to be clicked on
+ If this checkmark is clicked on then it will turn green and task will be crossed out



# Flow of application
+ TaskController
+ TaskService
+ TaskRepository
+ Task


## Task

What is a task? (in my own words)
<br>


A task is something a person needs to do for example lets say a student is busy and needs to spread his work <br>
he/she can have a task such as:
+ do homework
+ study for math class
+ brush teeth

etc.


Task will have
an:

+ id
+ description
+ date created
+ status

+ status will represent if a task is completed or not <br> 
+ description will describe in detail what the task is
+ date created will represent the time and date the task was created
+ id will represent the task in order


## TaskController

This class is to handle all endpoints from client to server.

Example: When a user adds a task it will do a _POST_ request

### Methods:
+ createTask()
+ readTask()
+ updateTask()
+ deleteTask()

## TaskService

+ This class is responsible in talking to the repository.
+ Provide DB queries from the repo into service to finally the controller. 
+ Annotate the Service class with @Autowire


## TaskRepository

This interface connects with the database <br>
This interface will talk to the service and from there it will reach the controller

```java

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}

```












