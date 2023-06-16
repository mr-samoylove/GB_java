package sem4;

public class ArrayHandler {
    public static int sumStringArray4x4(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4)
            throw new MyArraySizeException("Количество элементов внешнего массива не равно 4");

        int counter = 0;
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException(String.format("Количество строк внутреннего массива номер %d не равно 4", i));
            for (int j = 0; j < 4; j++) {
                try {
                    counter += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("Найден элемент, не конвертируемый в целое число: %s, строка:%d колонка:%d",
                                    array[i][j], i, j));
                }
            }
        }
        return counter;
    }
}
