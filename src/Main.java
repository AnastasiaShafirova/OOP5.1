import controller.Controller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.createStudent("Безрукова", "Мария", "Эдуардовна"); //вносим студентов
        controller.createStudent("Агапова", "Кристина", "Витальевна");
        controller.createStudent("Петров", "Иван", "Игоревич");

        controller.createStudent("Мещеряков", "Петр", "Алексеевич"); //вносим преподавателей

        controller.getAllStudent();

        controller.createStudyGroup(132); // id преподавателя
    }

}