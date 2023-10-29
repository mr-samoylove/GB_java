package Seminar03;


public class Manager extends Worker {
    public Manager(String name, int salary) {
        super(name, salary);
    }


    public static void changeWorkerSalaryByPercent(Worker worker, int percent) {
        if (!(worker instanceof Manager))  // зарплата менеджера не меняется
            worker.salary += worker.salary * percent / 100;
    }

    public static void changeWorkerSalaryByAmount(Worker worker, int amount) {
        if (!(worker instanceof Manager))  // зарплата менеджера не меняется
            worker.salary += amount;
    }
}
