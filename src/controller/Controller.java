package controller;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;

import java.util.List;

public class Controller {
    private final DataService service = new DataService();

    private  final StudyGroupService studyGroupService = new StudyGroupService();

    private final StudentView view = new StudentView();// для вывода данных о наших студентах в консоли

    public void createStudent(String firstName, String lastName, String middleName) { //метод создания студента в сервисе
        service.create(firstName, lastName, middleName, Type.STUDENT);
    }
    public  void getAllStudent() {// возвращение всех студентов в сервисе
        List<User> userList = service.getAllStudent();
        for (User user : userList) {
            Student student = (Student) user;
            view.printOnConsole(student);
        }
    }


    public void createGroup(Teacher teacher, List<Student> students) {
        studyGroupService.create(teacher, students);
    }

    public void createStudyGroup(int teacherId) {
        // Получаем преподавателя по его ID
        Teacher teacher = (Teacher) service.getUserId(Type.TEACHER, teacherId);

        // Получаем всех студентов
        List<User> userList = service.getAllStudent();
        List<Student> students = userList.stream()
                .map(user -> (Student) user)
                .toList();

        // Создаём учебную группу
        if (teacher != null && !students.isEmpty()) {
            createGroup(teacher, students);
            System.out.println("Учебная группа создана с преподавателем: " + teacher.getFirstName());
        } else {
            System.out.println("Ошибка создания учебной группы: проверьте ID преподавателя или наличие студентов.");
        }
    }
}