package Seminar03;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Worker("John", 1000));
        workers.add(new Worker("Sam", 2000));
        workers.add(new Worker("Lizzy", 3000));
        workers.add(new Manager("Garold", 10000)); // зарплата менеджера не меняется

        for (Worker worker :
                workers) {
            Manager.changeWorkerSalaryByPercent(worker, -10);
            System.out.printf("Name: %s, salary: %d\n", worker.getName(), worker.getSalary());
        }
    }
}
