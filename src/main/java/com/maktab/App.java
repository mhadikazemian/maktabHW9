package com.maktab;

import com.maktab.model.Student;
import com.maktab.model.Teacher;
import com.maktab.model.dao.StudentDAO;
import com.maktab.model.dao.StudentDaoImpl;
import com.maktab.model.dao.TeacherDAO;
import com.maktab.model.dao.TeacherDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import javax.persistence.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        TeacherDAO teacherDao = new TeacherDaoImpl(factory);
        StudentDAO studentDAO = new StudentDaoImpl(factory);
        Teacher teacher = null;
        Teacher teacher2 = null;
        Student student = null;
        teacher = new Teacher("saman", "Smith", "2222", 452, LocalDate.of(2000, 05, 4));
        teacher2 = new Teacher("Ali", "Mammadi", "3222", 454, LocalDate.of(1995, 10, 5));
        student = new Student("mohammad", "Ali");
        teacherDao.create(teacher);
        teacherDao.create(teacher2);
        studentDAO.create(student);
        studentDAO.search("mohammad");
        teacherDao.extremeAge();
        teacherDao.max_MinSalary();
        teacherDao.deleteTeacher("3222");
        studentDAO.search("mohammad");
        factory.close();
    }//end of main method
}//end of App class
