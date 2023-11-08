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
                .reduce(Double::sum)
                .orElse(0.0)
                / grades.size();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }
}
