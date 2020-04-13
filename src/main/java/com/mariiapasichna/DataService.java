package com.mariiapasichna;

import com.mariiapasichna.dao.GroupDao;
import com.mariiapasichna.dao.StudentDao;
import com.mariiapasichna.models.Group;
import com.mariiapasichna.models.Student;

import java.util.List;

public class DataService {
    private StudentDao studentDao = new StudentDao();
    private GroupDao groupDao = new GroupDao();

    public void clear() {
        studentDao.clear();
        groupDao.clear();
    }

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public void addGroup(String group) {
        groupDao.addGroup(new Group(group));
    }

    public Group getGroup(String name) {
        return groupDao.getGroup(name);
    }

    public List<Student> getStudentsByGroup(String groupName) {
        return studentDao.getStudentsByGroup(groupName);
    }

    public List<Group> getGroupsByStudentName(String studentName) {
        return studentDao.getGroupsByStudentName(studentName);
    }

    public void close() {
        studentDao.close();
        groupDao.close();
    }
}