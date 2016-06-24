package ru.polinabevad.bugtracker.core.services;

import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.StatusType;

import java.util.List;

public interface MessageService {

    Message findById(int id);

    void saveMessage(Message message);

    void updateMessage(Message message);

    void deleteMessageById(Integer id);

    List<Message> findAllMessagesTasks();

    List<Message> findMessagesByTaskId(Integer taskId);

    StatusType changeTaskStatus(StatusType statusTypeTo, Message message);
}

