package com.maktab.model.dao;


import com.maktab.core.dao.BaseDaoImpl;
import com.maktab.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDAO {
    private Session session;

    public StudentDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public String getEntityName() {
        return "Student";
    }

    public void search(String name) {
        session = factory.openSession();
        Query student = session.createQuery("from Student where firstName like :name or lastName like :name").setParameter("name", name);
        List result = student.list();
        System.out.println(result);
    }

}//end of StudentDaoImp class
