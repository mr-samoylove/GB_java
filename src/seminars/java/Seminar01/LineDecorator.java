package Seminar01;

import java.time.LocalDateTime;

public class LineDecorator {
    public static String decorate (String string) {
        return String.format("Дозапись в файл: %s -> %s\n", LocalDateTime.now(), string);
    }
}
