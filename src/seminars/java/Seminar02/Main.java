package Seminar02;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int arrayLength = 10;
        int lowerBound = -20;
        int upperBound = 20;

        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = random.nextInt(lowerBound, upperBound);
        }

//        arr[5] = 0;  // testing
//        arr[6] = 0;  // testing

        System.out.println("Сгенерированный массив: " + Arrays.toString(arr));
        System.out.println("Количество четных чисел: " + IntArrayProcessor.countEvens(arr));
        System.out.println("Разница между самым большим и самым маленьким элементами: " + IntArrayProcessor.diffMaxMinValues(arr));
        System.out.printf("В массиве %s 2 идущих подряд значений 0", IntArrayProcessor.hasTwoZerosSequentially(arr) ? "EСТЬ" : "НЕТ");
    }
}
