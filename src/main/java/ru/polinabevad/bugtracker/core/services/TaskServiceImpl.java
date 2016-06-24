package ru.polinabevad.bugtracker.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.dao.TaskDao;

import java.util.List;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskDao dao;

    public Task findByTaskId(int taskId) {
        return dao.findByTaskId(taskId);
    }

    public void saveTask(Task task) {
        dao.saveTask(task);
    }

    public void updateTask(Task task) {
        Task entity = dao.findByTaskId(task.getTaskId());
        if (entity!=null) {
            entity.setTaskAuthor(task.getTaskAuthor());
            entity.setTaskAppointer(task.getTaskAppointer());
            entity.setTaskStatus(task.getTaskStatus());
        }
    }

    public void deleteTaskById(Integer taskId) {
        dao.deleteTaskById(taskId);
    }

    public List<Task> findAllTasks() {
        return dao.findAllTasks();
    }
}
