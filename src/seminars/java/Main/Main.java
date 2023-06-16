package Main;

import sem4.*;


public class Main {
    public static void main(String[] args) {

        // нормальный массив
        String[][] array1 = {{"1", "22", "44", "12345"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}};

        // массивы иных размеров
        String[][] array2 = {{"1", "22", "44", "12345"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}};
        String[][] array3 = {{"1", "22", "44"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}};

        // массивы с неверными данными
        String[][] array4 = {{"1", "22", "44", "12345"}, {"sobaka", "0", "0", "0"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}};
        String[][] array5 = {{"1", "22", "44", "12345.54321"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}};

        System.out.println(ArrayHandler.sumStringArray4x4(array1));

        try {
            System.out.println(ArrayHandler.sumStringArray4x4(array2));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ArrayHandler.sumStringArray4x4(array3));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ArrayHandler.sumStringArray4x4(array4));
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ArrayHandler.sumStringArray4x4(array5));
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
}