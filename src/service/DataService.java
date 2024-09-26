package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    private List<User> userList;

    public void create(String firstName, String lastName, String middleName, Type type) { //добавление студента или учителя
        int id = getFreeId(type);
        if (Type.STUDENT == type) {
            Student student = new Student(firstName, lastName, middleName, id);
            userList.add(student); // добавляем в коллекцию
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userList.add(teacher); // добавляем в коллекцию
        }
    }

    public  User getUserId(Type type, int id) { //поиск пользователя
        boolean itsStudent = Type.STUDENT == type;
        User currentuser = null;
        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent && ((Teacher) user). getTeacherId() == id) {
                currentuser = user;
            }
            if (user instanceof Student && itsStudent && ((Student) user).getStudentId() == id) {
                currentuser = user;
            }
        }
        return currentuser;
    }

    public List<User> getAllUsers() { //вывод всех пользователей
        return userList;
    }
    public List<User> getAllStudent() { //вывод студентов
        List<User> students = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                students.add(user);
            }
        }
        return students;
    }

    private int getFreeId(Type type) { // присвоение id
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user : userList) {
            if (user instanceof Teacher && !itsStudent) {
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if (user instanceof Student && itsStudent) {
                lastId = ((Student) user).getStudentId() +1;
            }
        }
        return lastId;
    }
}


