package com.hjh;

import com.hjh.dao.StudentDao;
import com.hjh.daoImpl.StudentDaoImpl;
import java.util.List;
import com.hjh.model.Student;
import org.junit.Assert;
import org.junit.Test;

public class DaoTest {
    /**
     * 测试dao
     */
    @Test
    public void daoTest() {
        StudentDao studentDao = new StudentDaoImpl();

        //插入学生数据
        studentDao.insertStudent(1, "slf1");
        studentDao.insertStudent(2, "slf2");
        studentDao.insertStudent(3, "slf3");
        List<Student> students = studentDao.queryAll();
        System.out.println(students);
        Assert.assertEquals(students.size(), 3);

        //查询id为1的学生信息
        Student student = studentDao.queryStudentById(1);
        System.out.println(student);
        Assert.assertEquals(student.getName(), "slf1");

        //更新id为2学生的name
        studentDao.updateStudentById(2, "张三");
        student = studentDao.queryStudentById(2);
        System.out.println(student);
        Assert.assertEquals(student.getName(), "张三");

        //删除id为3的学生信息
        studentDao.deleteStudentById(3);
        students = studentDao.queryAll();
        System.out.println(students);
        Assert.assertEquals(students.size(), 2);
    }
}
