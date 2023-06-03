package Main;

import sem3.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new HourlyPaidWorker(7));
        workers.add(new HourlyPaidWorker(700));
        workers.add(new HourlyPaidWorker(800));
        workers.add(new MonthlyPaidWorker(60000));
        workers.add(new MonthlyPaidWorker(70000));
        workers.add(new MonthlyPaidWorker(10000));

        // в) ** Реализовать интерфейсы для возможности сортировки массива
        Collections.sort(workers);
        System.out.println(workers);
        for (Worker worker : workers) {
            System.out.println(worker.getMonthlyAverageSalary());
        }

        System.out.println();

        // г) ** Создать класс, содержащий массив сотрудников, и реализовать возможность вывода данных с использованием foreach.
        AllWorkers allWorkers = new AllWorkers();
        allWorkers.add(new HourlyPaidWorker(7));
        allWorkers.add(new HourlyPaidWorker(700));
        allWorkers.add(new HourlyPaidWorker(800));
        allWorkers.add(new MonthlyPaidWorker(60000));
        allWorkers.add(new MonthlyPaidWorker(70000));
        allWorkers.add(new MonthlyPaidWorker(10000));

        allWorkers.printAllWorkers();
    }
}