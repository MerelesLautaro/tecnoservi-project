package com.lautadev.tecnoservi_project.controller;

import com.lautadev.tecnoservi_project.model.Task;
import com.lautadev.tecnoservi_project.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@PreAuthorize("permitAll()")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<String> createTask(@RequestBody Task task){
        taskService.saveTask(task);
        return ResponseEntity.ok("Task created successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<List<Task>> getTask(){
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> findTask(@PathVariable Long id){
        Optional<Task> task = taskService.findTask(id);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> editTask(@PathVariable Long id, @RequestBody Task task){
        taskService.editTask(id,task);
        return ResponseEntity.ok("Task edited");
    }
}
