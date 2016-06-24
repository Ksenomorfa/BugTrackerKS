package ru.polinabevad.bugtracker.core.services;

import ru.polinabevad.bugtracker.core.People;

import java.util.List;

/**
 * Тип пользователя: админский или нет, у админского будут права на удаление задач\сообщений
 */
public interface PeopleService {

    public People findById(int id);

    void savePeople(People people);

    void updatePeople(People people);

    void deletePeopleById(Integer id);

    List<People> findAllPeoples();
}

