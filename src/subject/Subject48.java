package subject;

import java.util.Arrays;

public class Subject48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int tmp;
        int nextX;
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                nextX = length - i - 1;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[nextX][j];
                matrix[nextX][j] = tmp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Subject48 subject48 = new Subject48();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        subject48.rotate(matrix);
        for (int[] vet : matrix) {
            System.out.println(Arrays.toString(vet));
        }
    }
}
