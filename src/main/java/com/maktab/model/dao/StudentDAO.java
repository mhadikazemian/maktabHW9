package com.maktab.model.dao;

import com.maktab.core.dao.BaseDAO;
import com.maktab.model.Student;


public interface StudentDAO extends BaseDAO<Student> {
    void search(String name);
}//end of StudentDAO interface
