package ru.polinabevad.bugtracker.core.services;

import ru.polinabevad.bugtracker.core.Message;

import java.util.List;

/**
 * Тип пользователя: админский или нет, у админского будут права на удаление задач\сообщений
 */
public interface MessageService {

    Message findById(int id);

    void saveMessage(Message message);

    void updateMessage(Message message);

    void deleteMessageById(Integer id);

    List<Message> findAllMessagesTasks();

    List<Message> findMessagesByTaskId(Integer taskId);

    void deleteAllMessages();
}

