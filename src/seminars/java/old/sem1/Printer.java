package old.sem1;

public class Printer {
    public final <T> void printToConsole(T... t){
        for (T t1 : t) {
            System.out.println(t1);
        }
    }
}
