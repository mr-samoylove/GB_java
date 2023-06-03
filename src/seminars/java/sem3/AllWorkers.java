package sem3;

import java.util.ArrayList;
import java.util.Iterator;

public class AllWorkers implements Iterable<Worker> {
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

    public Iterator<Worker> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<Worker> {
        private int index = 0;

        public boolean hasNext() {
            return index < workers.size();
        }

        public Worker next() {
            return workers.get(index++);
        }
    }
}
