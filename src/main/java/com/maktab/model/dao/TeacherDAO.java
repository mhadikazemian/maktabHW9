package com.maktab.model.dao;

import com.maktab.core.dao.BaseDAO;
import com.maktab.model.Teacher;

public interface TeacherDAO extends BaseDAO<Teacher> {
    void deleteTeacher(String teacherCod);

    void max_MinSalary();

    void extremeAge();
}//end of TeacherDAO interface
