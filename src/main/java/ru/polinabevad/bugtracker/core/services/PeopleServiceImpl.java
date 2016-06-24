package ru.polinabevad.bugtracker.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;
import ru.polinabevad.bugtracker.core.dao.PeopleDao;
import ru.polinabevad.bugtracker.core.dao.TaskDao;

import java.util.List;

@Service ("peopleService")
@Transactional
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    private PeopleDao dao;

    public People findById(int id) {
        return dao.findById(id);
    }

    public void savePeople(People people) {
        dao.savePeople(people);
    }

    public void updatePeople(People people) {
        People entity = dao.findById(people.getUserId());

        if (entity!=null) {
            entity.setLogin(entity.getLogin());
        }
    }

    public void deletePeopleById(Integer id) {
        dao.deletePeopleById(id);
    }

    public List<People> findAllPeoples() {
        return dao.findAllPeoples();
    }
}

