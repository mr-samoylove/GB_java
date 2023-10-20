package Seminar02;

public class IntArrayProcessor {
    /**
     * метод, возвращающий количество чётных элементов массива
     */
    public static int countEvens(int[] arr) {
        int count = 0;
        for (int a : arr)
            count += a % 2 == 0 ? 1 : 0;  // +1 если четное, +0 если нечетное

        return count;
    }

    /**
     * метод, возвращающий разницу между самым большим и самым маленьким элементами переданного непустого массива
     */
    public static int diffMaxMinValues(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int a : arr) {
            if      (a < min) min = a;
            else if (a > max) max = a;
        }
        return max - min;
    }

    /**
     * метод возвращающает истину, если в переданном массиве есть два соседних элемента с нулевым значением
     */
    public static boolean hasTwoZerosSequentially(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 && arr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }
}
