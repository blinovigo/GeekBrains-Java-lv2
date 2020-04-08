package lesson2;

public class Main {

    public static void main(String[] args) {
        String string = "10 3 1 2 \n2 3 2 2 \n5 6 7 1 \n300 3 1 0";

        try {
            String[][] matrix = arrayConverter(string);
            System.out.println(halfSumMatrix(matrix));
        } catch (NumberFormatException e) {
            System.err.println("Массив должен содержать только числа");
        } catch (WrongSizeMatrixException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("не поймано");
        }
    }

    private static String[][] arrayConverter(String string) throws WrongSizeMatrixException {
        String[] strings = string.split("\n");
        String[] arr = strings[0].split(" ");

        if (strings.length != 4 | arr.length != 4) throw new WrongSizeMatrixException("Размер матрицы не равен 4");
        String[][] matrix = new String[strings.length][arr.length];

        for (int i = 0; i < strings.length; i++) {
            arr = strings[i].split(" ");
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = arr[j];
            }
        }
        return matrix;
    }

    private static int halfSumMatrix(String[][] matrix) throws WrongStringValueException {
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    result += Integer.parseInt(matrix[i][j]);
            }
        }
        result = result/2;
        return result;
    }
}
