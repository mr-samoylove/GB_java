package old.sem3;

public abstract class Worker  implements Comparable<Worker>{

    public abstract int getMonthlyAverageSalary();

    public int compareTo(Worker other) {
        return this.getMonthlyAverageSalary() - other.getMonthlyAverageSalary();
    }
}
