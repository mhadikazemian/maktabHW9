package com.maktab.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDaoImpl<E extends Serializable> implements BaseDAO<E> {

    protected SessionFactory factory;

    public BaseDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    protected abstract String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public E update(E e) {

        Session session = factory.openSession();

        session.beginTransaction();

        session.update(e);

        session.getTransaction().commit();

        session.close();

        return null;
    }

    @Override
    public E read(Serializable id) {
        Session session = factory.openSession();

        session.beginTransaction();

        E e2 = (E) session.get(getEntityName(), id);

        session.getTransaction().commit();

        session.close();

        return e2;
    }

    @Override
    public void delete(Serializable id) {
        Session session = factory.openSession();

        session.beginTransaction();

        E e2 = (E) session.get(getEntityName(), id);

        session.delete(e2);

        session.getTransaction().commit();

        session.close();

    }

}//end of BaseDaoImpl abstract class
