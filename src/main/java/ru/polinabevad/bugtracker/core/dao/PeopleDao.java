package ru.polinabevad.bugtracker.core.dao;

import ru.polinabevad.bugtracker.core.People;

import java.util.List;

public interface PeopleDao{

    People findById(Integer id);

    void savePeople(People people);

    void deletePeopleById(Integer id);

    List<People> findAllPeoples();

    List<People> findByName(String name);
}