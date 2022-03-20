package com.hjh.daoImpl;

import com.hjh.connection.ConnectUtil;
import com.hjh.dao.StudentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hjh.model.Student;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> queryAll() {
        List<Student> students = new ArrayList<>();

        try {
            Connection conn = ConnectUtil.getConn();
            String sql = "SELECT * FROM student";
            PreparedStatement preSt = conn.prepareStatement(sql);
            ResultSet resultSet = preSt.executeQuery();
            while(resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student queryStudentById(int id) {
        Student student = null;

        try {
            Connection conn = ConnectUtil.getConn();
            String sql = "SELECT * FROM student WHERE id = ?";
            PreparedStatement preSt = conn.prepareStatement(sql);
            preSt.setInt(1, id);
            ResultSet resultSet = preSt.executeQuery();
            resultSet.next();
            student = new Student(resultSet.getInt("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public void insertStudent(int id, String name) {
        try {
            Connection conn = ConnectUtil.getConn();
            String sql = "INSERT INTO student (id, name) VALUES (?, ?)";
            PreparedStatement preSt = conn.prepareStatement(sql);
            preSt.setInt(1, id);
            preSt.setString(2, name);
            preSt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudentById(int id, String name) {
        try {
            Connection conn = ConnectUtil.getConn();
            String sql = "UPDATE student SET name = ? WHERE id = ?";
            PreparedStatement preSt = conn.prepareStatement(sql);
            preSt.setString(1, name);
            preSt.setInt(2, id);
            preSt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(int id) {
        try {
            Connection conn = ConnectUtil.getConn();
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement preSt = conn.prepareStatement(sql);
            preSt.setInt(1, id);
            preSt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
