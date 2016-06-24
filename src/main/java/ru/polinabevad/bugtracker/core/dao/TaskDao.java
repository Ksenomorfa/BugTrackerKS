package ru.polinabevad.bugtracker.core.dao;

import ru.polinabevad.bugtracker.core.Task;

import java.util.List;

public interface TaskDao {

    Task findByTaskId(Integer taskId);

    void saveTask(Task task);

    void deleteTaskById(Integer taskId);

    List<Task> findAllTasks();

    List<Task> findByTaskName(String taskName);

}
