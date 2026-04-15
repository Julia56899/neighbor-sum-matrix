import java.util.Random;
import java.util.Scanner;

public class Matrix {

    // метод для создания пустой матрицы — спрашивает у пользователя размеры N и M
    public static int[][] createMatrix() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите N:");
        int n = sc.nextInt();

        System.out.println("Введите M:");
        int m = sc.nextInt();

        // создаём двумерный массив нужного размера (пока везде нули)
        int[][] matrix = new int[n][m];
        return matrix;
    }

    // метод заполняет матрицу случайными числами от 1 до 9
    public static int[][] fillMatrix(int[][] matrix) {

        Random rand = new Random();

        // проходим по каждой строке
        for (int i = 0; i < matrix.length; i++) {
            // проходим по каждому столбцу в строке
            for (int j = 0; j < matrix[0].length; j++) {
                // nextInt(9) даёт 0..8, поэтому +1 чтобы получить 1..9
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
        return matrix;
    }

    // метод считает для каждого элемента сумму его соседей (сверху, снизу, слева, справа)
    public static int[][] computeSums(int[][] matrix) {

        // результирующая матрица того же размера
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int sum = 0;

                // сосед сверху — существует только если мы не в первой строке
                if (i > 0) {
                    sum += matrix[i - 1][j];
                }
                // сосед снизу — существует только если мы не в последней строке
                if (i < matrix.length - 1) {
                    sum += matrix[i + 1][j];
                }
                // сосед слева — существует только если мы не в первом столбце
                if (j > 0) {
                    sum += matrix[i][j - 1];
                }
                // сосед справа — существует только если мы не в последнем столбце
                if (j < matrix[0].length - 1) {
                    sum += matrix[i][j + 1];
                }

                // записываем сумму соседей в результирующую матрицу
                result[i][j] = sum;
            }
        }
        return result;
    }

    // метод выводит обе матрицы: исходную и матрицу сумм соседей
    public static void printMatrix(int[][] matrix, int[][] result) {

        System.out.println("Исходная матрица:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            // переходим на новую строку после каждой строки матрицы
            System.out.println();
        }

        System.out.println("Преобразованная матрица:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
