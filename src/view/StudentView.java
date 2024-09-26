package view;

import controller.Controller;
import model.Student;
import model.Teacher;
import service.StudyGroupService;

import java.util.ArrayList;
import java.util.List;

public class StudentView {

    public void printOnConsole(Student student) {
        System.out.println(student.toString());  //выводим на консоль
    }

}
