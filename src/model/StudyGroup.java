package model;

import java.util.ArrayList;
import java.util.List;

public class StudyGroup extends User{


    public String Teacher;
    public List<Student> students = new ArrayList<Student>();

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.Teacher = String.valueOf(teacher);
        this.students = students;
    }

    public String getTeacher() {
        return Teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
