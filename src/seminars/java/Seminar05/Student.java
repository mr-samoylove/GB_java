package Seminar05;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
public class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public Student(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;

        grades = new ArrayList<>();
    }

    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }
}
