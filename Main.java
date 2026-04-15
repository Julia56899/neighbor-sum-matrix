public class Main {

    public static void main(String[] args) {

        // создаём матрицу нужного размера — пользователь сам вводит N и M
        int[][] matrix = Matrix.createMatrix();

        // заполняем матрицу случайными числами от 1 до 9
        matrix = Matrix.fillMatrix(matrix);

        // считаем матрицу сумм соседей для каждого элемента
        int[][] result = Matrix.computeSums(matrix);

        // выводим обе матрицы — исходную и с суммами — на экран
        Matrix.printMatrix(matrix, result);
    }
}
