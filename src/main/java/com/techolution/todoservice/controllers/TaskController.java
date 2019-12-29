package com.techolution.todoservice.controllers;

import com.techolution.todoservice.models.Task;
import com.techolution.todoservice.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/task")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/task")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/task/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Integer userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PutMapping("/task")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/task/{taskId}")
    public Task deleteTask(@PathVariable String taskId) {
        return taskService.deleteTask(taskId);
    }

}
