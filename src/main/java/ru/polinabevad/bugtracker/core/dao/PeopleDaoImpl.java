package ru.polinabevad.bugtracker.core.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.polinabevad.bugtracker.core.Message;
import ru.polinabevad.bugtracker.core.People;
import ru.polinabevad.bugtracker.core.Task;

import java.util.List;

@Repository("peopleDao")
public class PeopleDaoImpl  extends DAO<Integer, People> implements PeopleDao {

    public People findById(Integer id) {
        return getById(id);
    }

    public void savePeople(People people) {
        persist(people);
    }

    public void deletePeopleById(Integer id) {
        Query query = getSession().createSQLQuery(
                "delete from users where userid = :userId");
        query.setInteger("userId", id);
        query.executeUpdate();
    }
    @SuppressWarnings("unchecked")
    public List<People> findAllPeoples() {
        Criteria criteria = createEntityCriteria();
        return (List<People>) criteria.list();
    }

    public List<People> findByLogin(String login) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("login", login));
        return (List<People>) criteria.list();

    }
}