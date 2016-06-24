package ru.polinabevad.bugtracker.core.dao;

import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.Task;

import java.util.List;



public interface MessageDao {
    Message findById(Integer id);

    void saveMessage(Message message);

    void deleteMessageById(Integer id);

    List<Message> findAllMessages();

    List<Message> findMessagesByTaskId(Integer taskId);

    public Integer findTaskIdByMessageId(Integer messageId);
}