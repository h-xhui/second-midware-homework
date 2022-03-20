package com.hjh.dao;

import java.util.List;
import com.hjh.model.Student;

public interface StudentDao {

    List<Student> queryAll();

    Student queryStudentById(int id);

    void insertStudent(int id, String name);

    void updateStudentById(int id, String name);

    void deleteStudentById(int id);
}
