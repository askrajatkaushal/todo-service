package com.techolution.todoservice.services;

import com.techolution.todoservice.models.Task;
import com.techolution.todoservice.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByUserId(Integer userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Task deleteTask(String taskId) {
        Optional<Task> task = taskRepository.findById(taskId);

        task.ifPresent(t -> {
            t.setDiscarded(true);
            taskRepository.save(t);
        });

        return task.orElse(null);
    }

}
