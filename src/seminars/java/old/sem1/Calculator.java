package old.sem1;

import java.util.stream.IntStream;

public class Calculator {
    public int sum(int... numbers){
        return IntStream.of(numbers).sum();
    }
}
