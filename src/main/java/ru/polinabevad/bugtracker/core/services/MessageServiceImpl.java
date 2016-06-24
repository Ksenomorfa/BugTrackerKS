package ru.polinabevad.bugtracker.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.StatusType;
import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.dao.MessageDao;
import ru.polinabevad.bugtracker.core.dao.TaskDao;

import java.util.List;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;
    @Autowired
    private TaskDao taskDao;

    public Message findById(int id) {
        return messageDao.findById(id);
    }

    public void saveMessage(Message message) {
        messageDao.saveMessage(message);
    }

    public void updateMessage(Message message) {
        Message entity = messageDao.findById(message.getMessageId());
        Integer taskId = messageDao.findTaskIdByMessageId(message.getMessageId());
        Task task = taskDao.findByTaskId(taskId);
        if (entity!=null) {
            entity.setMessageStatus(message.getMessageStatus());
            changeTaskStatus(message.getMessageStatus(),message);
        }
    }

    public void deleteMessageById(Integer id) {
        messageDao.deleteMessageById(id);
    }

    public List<Message> findAllMessagesTasks() {
        return messageDao.findAllMessages();
    }

    public List<Message> findMessagesByTaskId(Integer taskId) {
        return messageDao.findMessagesByTaskId(taskId);
    }


    public StatusType changeTaskStatus(StatusType statusTypeTo, Message message) {
        Integer taskId = messageDao.findTaskIdByMessageId(message.getMessageId());
        Task task = taskDao.findByTaskId(taskId);
        Message entity = messageDao.findById(message.getMessageId());

        StatusType statusTypeFrom = task.getTaskStatus();
        //разрешаем перевод из открыт в работу
        if ((statusTypeFrom == StatusType.OPEN) && (statusTypeTo == StatusType.WORK)) {
            task.setTaskStatus(statusTypeTo);
            entity.setMessageStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из работы в проверку
        if ((statusTypeFrom == StatusType.WORK) && (statusTypeTo == StatusType.CHECK)) {
            task.setTaskStatus(statusTypeTo);
            entity.setMessageStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в работу
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.WORK)) {
            task.setTaskStatus(statusTypeTo);
            entity.setMessageStatus(statusTypeTo);
            return task.getTaskStatus();
        }
        //разрешаем перевод из проверки в закрыт и обновляем дату закрытия задачи
        if ((statusTypeFrom == StatusType.CHECK) && (statusTypeTo == StatusType.CLOSE)) {
            task.setTaskStatus(statusTypeTo);
            entity.setMessageStatus(statusTypeTo);
            task.setCloseDate(entity.getMessageDate());
            return task.getTaskStatus();
        }
        task.setTaskStatus(statusTypeFrom);
        System.out.println("Невозможно перевести задачу в статус " + statusTypeTo.getStatusName() +
                ", т.к. она находится в статусе " + statusTypeFrom.getStatusName());
        return task.getTaskStatus();
    }
}

