package ru.polinabevad.bugtracker.core.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;

import java.util.List;

public interface PeopleDao{

    People findById(Integer id);

    void savePeople(People people);

    void deletePeopleById(Integer id);

    List<People> findAllPeoples();

    List<People> findByLogin(String login);

}