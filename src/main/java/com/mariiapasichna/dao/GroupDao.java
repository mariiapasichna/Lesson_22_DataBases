package com.mariiapasichna.dao;

import com.mariiapasichna.models.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class GroupDao {
    private SessionFactory sessionFactory;

    public GroupDao() {
        sessionFactory = Configurations.getConfigurations();
    }

    public void clear() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = String.format("DELETE FROM %s", Group.class.getSimpleName());
            session.createQuery(hql).executeUpdate();
            transaction.commit();
        }
    }

    public void addGroup(Group group) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
        }
    }

    public Group getGroup(String groupName) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM Group WHERE groupName = :groupName ", Group.class)
                    .setParameter("groupName", groupName)
                    .getSingleResult();
        }
    }

    public void close() {
        sessionFactory.close();
    }
}