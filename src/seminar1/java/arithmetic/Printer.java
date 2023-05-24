package arithmetic;

public class Printer {
    public <T> void printToConsole(T... t){
        for (T t1 : t) {
            System.out.println(t1);
        }
    }
}
