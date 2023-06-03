package sem3;

import java.util.ArrayList;

public class AllWorkers {
    public final ArrayList<Worker> workers;

    public AllWorkers() {
        this.workers = new ArrayList<>();
    }

    public void printAllWorkers() {
        for (Worker worker : workers) {
            System.out.println(worker.toString() + "Salary:" + worker.getMonthlyAverageSalary());
        }
    }

    public void add(Worker worker) {
        this.workers.add(worker);
    }
}
