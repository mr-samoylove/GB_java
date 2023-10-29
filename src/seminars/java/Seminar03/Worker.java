package Seminar03;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Worker {
    private final String name;
    protected int salary;

    public boolean datesAreEqual(Date first, Date second) {
        return first == second;
    }
}
