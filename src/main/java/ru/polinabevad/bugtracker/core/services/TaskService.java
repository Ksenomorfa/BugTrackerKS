package ru.polinabevad.bugtracker.core.services;

import ru.polinabevad.bugtracker.core.Task;

import java.util.List;

public interface TaskService {

    public Task findByTaskId(int taskId);

    void saveTask(Task task);

    void updateTask(Task task);

    void deleteTaskById(Integer taskId);

    List<Task> findAllTasks();

}
