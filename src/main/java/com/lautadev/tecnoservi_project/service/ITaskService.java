package com.lautadev.tecnoservi_project.service;

import com.lautadev.tecnoservi_project.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    public void saveTask(Task task);
    public List<Task> getTasks();
    public Optional<Task> findTask(Long id);
    public void deleteTask(Long id);
    public void editTask(Long id, Task task);
}
