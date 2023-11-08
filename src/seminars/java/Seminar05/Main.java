package Seminar05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("JohnWRONG1", "Engineer"));
        students.add(new Student("John2", "IT"));
        students.add(new Student("John3", "IT"));
        students.add(new Student("John4", "IT"));
        students.add(new Student("John5", "IT"));
        students.add(new Student("John6", "IT"));
        students.add(new Student("JohnWRONG7", "whatever"));
        students.add(new Student("John8", "IT"));

        // проставим всем рандомные оценки от 1 до 10
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            students.get(random.nextInt(0, 7)).addGrade(random.nextDouble(1, 10));
        }

        // выполним условия задачи
        List<Student> top5ItStudents = students.stream()
                .filter(stud -> stud.getSpecialty().equals("IT") && stud.getAverageGrade() >= 4.5)
                .sorted((a, b) -> (Double.compare(b.getAverageGrade(), a.getAverageGrade())))  // по убыванию
                .limit(5)
                .toList();

        // выведем на экран
        top5ItStudents.forEach(stud -> System.out.println("Student " + stud.getName() + ", average grade: " + stud.getAverageGrade()));
    }
}
