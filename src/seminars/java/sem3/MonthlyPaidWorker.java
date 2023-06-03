package sem3;

public class MonthlyPaidWorker extends Worker {
    int salary;

    public MonthlyPaidWorker(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthlyAverageSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "MonthlyPaidWorker{" +
                "salary=" + salary +
                '}';
    }
}
