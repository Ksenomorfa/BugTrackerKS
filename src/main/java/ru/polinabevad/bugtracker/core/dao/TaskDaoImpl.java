package ru.polinabevad.bugtracker.core.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.polinabevad.bugtracker.core.Task;

import java.util.List;

@Repository("taskDao")
public class TaskDaoImpl extends DAO<Integer, Task> implements TaskDao {

    public Task findByTaskId(Integer taskId) {
        return getById(taskId);
    }

    public void saveTask(Task task) {
        persist(task);
    }

    public void deleteTaskById(Integer taskId) {
        Query query = getSession().createSQLQuery(
                "delete from task where taskid = :taskId");
        query.setInteger("taskId", taskId);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Task> findAllTasks(){
        Criteria criteria = createEntityCriteria();
        return (List<Task>) criteria.list();
    }

    public List<Task> findByTaskName(String taskName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("taskName", taskName));
        return (List<Task>) criteria.list();
    }


}
