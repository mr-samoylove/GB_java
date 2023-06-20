package old.sem3;

public class HourlyPaidWorker extends Worker {
    static final double SALARY_MONTHLY_COEFFICIENT = 20.8 * 8;

    int hourlySalary;

    public HourlyPaidWorker(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public int getMonthlyAverageSalary() {
        return (int) Math.round(this.hourlySalary * HourlyPaidWorker.SALARY_MONTHLY_COEFFICIENT);
    }

    @Override
    public String toString() {
        return "HourlyPaidWorker{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
