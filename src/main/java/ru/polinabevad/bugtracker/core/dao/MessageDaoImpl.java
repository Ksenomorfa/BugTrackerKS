package ru.polinabevad.bugtracker.core.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.Task;

import java.util.List;

@Repository("messageDao")
public class MessageDaoImpl extends DAO<Integer, Message> implements MessageDao {
    public Message findById(Integer id) {
        return getById(id);
    }

    public void saveMessage(Message message) {
        persist(message);
    }

    public void deleteMessageById(Integer id) {
        Query query = getSession().createSQLQuery(
                "delete from message where messageid = :messageId");
        query.setInteger("messageId", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Message> findAllMessages() {
        Criteria criteria = createEntityCriteria();
        return (List<Message>) criteria.list();
    }

    public List<Message> findMessagesByTaskId(Integer taskId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("taskId", taskId));
        return (List<Message>) criteria.list();
    }

    @Override
    public Integer findTaskIdByMessageId(Integer messageId) {
        Query query = getSession().createSQLQuery(
                "select taskid from message where messageid = :messageId");
        query.setInteger("messageId", messageId);
        return query.getFirstResult();
    }
}