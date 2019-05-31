package com.maktab.model.dao;

import com.maktab.core.dao.BaseDaoImpl;
import com.maktab.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDAO {

    private Session session;

    public TeacherDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public String getEntityName() {
        return "Teacher";
    }

    public void deleteTeacher(String code) {
        session = factory.openSession();
        session.beginTransaction();
        Query teacher = session.createQuery("delete from Teacher where teacherCode = " + code + "");
        teacher.executeUpdate();
        session.close();
    }

    public void max_MinSalary() {
        List<Teacher> mxmn = new ArrayList<>();
        session = factory.openSession();
        mxmn.add((Teacher) session.createQuery("from Teacher e where e.salary = (select max(b.salary) from Teacher b) ").getSingleResult());
        mxmn.add((Teacher) session.createQuery("from Teacher e where e.salary = (select min(b.salary) from Teacher b) ").getSingleResult());
        System.out.println(mxmn);
        session.close();
    }

    public void extremeAge() {
        session = factory.openSession();
        List<Teacher> extremeAge = new ArrayList<>();
        extremeAge.add((Teacher) session.createQuery(" from Teacher e where e.birthday = (select min (b.birthday) from Teacher b) ").getSingleResult());
        extremeAge.add((Teacher) session.createQuery(" from Teacher e where e.birthday = (select max (b.birthday) from Teacher b) ").getSingleResult());
        System.out.println(extremeAge);
        session.close();
    }

}//end of TeacherDaoImpl class
