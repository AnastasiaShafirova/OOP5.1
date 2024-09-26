package service;

import model.Student;
import model.StudyGroup;
import model.Teacher;

import java.lang.reflect.Type;
import java.util.List;

public class StudyGroupService {
    public StudyGroup create(Teacher teacher, List<Student> students){
        return new StudyGroup(teacher, students);
    }
}
